package kevin.cp;


import java.util.HashMap;
import kevin.cp.FirstProviderMetaData.UserTableMetaData;
import kevin.db.DatabaseHelper;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

public class FirstContentProvider extends ContentProvider {

	public static final UriMatcher uriMatcher;
	public static final int INCOMING_USER_COLLECTION = 1;
	public static final int INCOMING_USER_SINGLE = 2;
	private DatabaseHelper dh;
	static {
	
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(FirstProviderMetaData.AUTHORIY, "/users",
				INCOMING_USER_COLLECTION);
		uriMatcher.addURI(FirstProviderMetaData.AUTHORIY, "/users/#",
				INCOMING_USER_SINGLE);
	}
	public static HashMap<String, String> userProjectionMap;
	static {
		userProjectionMap = new HashMap<String, String>();
		userProjectionMap.put(UserTableMetaData._ID, UserTableMetaData._ID);
		userProjectionMap.put(UserTableMetaData.USER_NAME,
				UserTableMetaData.USER_NAME);
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		System.out.println("delete");
		
		return 0;
	}

	/**
	 * ���ݴ����URI,���ظ�RUI����ʾ����������
	 */
	@Override
	public String getType(Uri uri) {
		System.out.println("GetType");
		switch (uriMatcher.match(uri)) {
		case INCOMING_USER_COLLECTION:
			return UserTableMetaData.CONTENT_TYPE;
		case INCOMING_USER_SINGLE:
			return UserTableMetaData.CONTENT_TYPE_ITEM;
		default:
			System.out.println("������");
			throw new IllegalArgumentException("Unknow URI" + uri);
		}
	}

	/**
	 * �ú����ķ���ֵ��һ��URI,���URI��ʾ���Ǹո�ʹ�����������
	 * �����������
	 * content://kevin.cp.FirstContentProvider/users/1 //�����1�����¼
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		System.out.println("insert");
		SQLiteDatabase db = dh.getWritableDatabase();
		long rowId = db.insert(UserTableMetaData.TABLE_NAME, null, values);
		if(rowId > 0){
			Uri insertedUserUri = ContentUris.withAppendedId(UserTableMetaData.CONTENT_URI, rowId);
			//֪ͨ������.�����Ѿ��ı�
			getContext().getContentResolver().notifyChange(insertedUserUri, null);
			return insertedUserUri;
		}
		throw new SQLException("Failed to insert rwo into" + uri);
	}

	/**
	 * ��һ���ص�����,����˵��ContentProvider������ʱ��ִ��
	 */
	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		dh = new DatabaseHelper(getContext(), FirstProviderMetaData.DATABASE_NAME);
		System.out.println("onCreate");
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,String[] selectionArgs, String sortOrder) {
		System.out.println("������");
		SQLiteQueryBuilder  qb = new SQLiteQueryBuilder();
		System.out.println("����2");
		switch (uriMatcher.match(uri)) {
		case INCOMING_USER_COLLECTION :
				System.out.println("����3");
				qb.setTables(UserTableMetaData.TABLE_NAME);
				System.out.println("a");
				qb.setProjectionMap(userProjectionMap);
				System.out.println("b");
		break;
		case INCOMING_USER_SINGLE :
				System.out.println("����4");
				qb.setTables(UserTableMetaData.TABLE_NAME);
				System.out.println("C");
				qb.setProjectionMap(userProjectionMap);
				System.out.println("d");
				qb.appendWhere(UserTableMetaData._ID + " = " +uri.getPathSegments().get(1));
				System.out.println("e");
		break;
		default:
			qb.setTables(UserTableMetaData.TABLE_NAME);
			qb.setProjectionMap(userProjectionMap);
			System.out.println("����6");
		}
		String orderBy;
		if(TextUtils.isEmpty(sortOrder)){
			orderBy = UserTableMetaData.DEFAULT_SORT_CREDR;
		}else{
			orderBy = sortOrder;
		}
		SQLiteDatabase db = dh.getWritableDatabase();
		Cursor c = qb.query(db, null, null, null, null, null, orderBy);
		c.setNotificationUri(getContext().getContentResolver(), uri);
		System.out.println("query");
		return c;
		
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
