package itangqi.me.mygreendao;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.text.DateFormat;
import java.util.Date;

import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import me.itangqi.greendao.DaoMaster;
import me.itangqi.greendao.DaoSession;
import me.itangqi.greendao.Note;
import me.itangqi.greendao.NoteDao;


public class NoteActivity extends ListActivity {
    private SQLiteDatabase db;
    private EditText editText;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private Cursor cursor;
    public static final String TAG = "DaoExample";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        // 官方推荐将获取 DaoMaster 对象的方法放到 Application 层，这样将避免多次创建生成 Session 对象
        setupDatabase();
        // 获取 NoteDao 对象
        getNoteDao();

        String textColumn = NoteDao.Properties.Text.columnName;
        String orderBy = textColumn + " COLLATE LOCALIZED ASC";
        cursor = db.query(getNoteDao().getTablename(), getNoteDao().getAllColumns(), null, null, null, null, orderBy);
        String[] from = {textColumn, NoteDao.Properties.Comment.columnName};
        int[] to = {android.R.id.text1, android.R.id.text2};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from,
                to);
        setListAdapter(adapter);

        editText = (EditText) findViewById(R.id.editTextNote);
    }

    private void setupDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    private NoteDao getNoteDao() {
        return daoSession.getNoteDao();
    }

    /**
     * Button 点击的监听事件
     *
     * @param view
     */
    public void onMyButtonClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAdd:
                addNote();
                break;
            case R.id.buttonSearch:
                search();
                break;
            default:
                Log.d(TAG, "what has gone wrong ?");
                break;
        }
    }

    private void addNote() {
        String noteText = editText.getText().toString();
        editText.setText("");

        final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        String comment = "Added on " + df.format(new Date());

        // 插入操作，简单到只要你创建一个 Java 对象
        Note note = new Note(null, noteText, comment, new Date());
        getNoteDao().insert(note);
        Log.d(TAG, "Inserted new note, ID: " + note.getId());
        cursor.requery();
    }

    private void search() {
        // Query 类代表了一个可以被重复执行的查询
        Query query = getNoteDao().queryBuilder()
                .where(NoteDao.Properties.Text.eq("Test1"))
                .orderAsc(NoteDao.Properties.Date)
                .build();

//      查询结果以 List 返回
//      List notes = query.list();
        // 在 QueryBuilder 类中内置两个 Flag 用于方便输出执行的 SQL 语句与传递参数的值
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }

    /**
     * ListView 的监听事件，用于删除一个 Item
     * @param l
     * @param v
     * @param position
     * @param id
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // 删除操作，你可以通过「id」也可以一次性删除所有
        getNoteDao().deleteByKey(id);
//        getNoteDao().deleteAll();
        Log.d(TAG, "Deleted note, ID: " + id);
        cursor.requery();
    }
}