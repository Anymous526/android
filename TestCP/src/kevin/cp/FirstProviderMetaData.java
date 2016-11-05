package kevin.cp;

import android.net.Uri;
import android.provider.BaseColumns;

public class FirstProviderMetaData {
	public static final String AUTHORIY = "kevin.cp.FirstContentProvider";
	// ���ݿ�����
	public static final String DATABASE_NAME = "FirstProvider.db";
	// ���ݿ�İ汾
	public static final int DATABASE_VERSION = 1;
	// ����
	public static final String USERS_TABLE_NAME = "users";

	public static final class UserTableMetaData implements BaseColumns {
		// ����
		public static final String TABLE_NAME = "users";
		// ���ʸ�ContentProvider�� URI
		public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORIY
				+ "/users");
		// �� ContentProvder �����ص��������͵Ķ���
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.firstprovider.user";
		public static final String CONTENT_TYPE_ITEM = "vnd.android.cursor.item/vnd.firstprovider.user";
		// ����
		public static final String USER_NAME = "name";
		// Ĭ�ϵ����򷽷�
		public static final String DEFAULT_SORT_CREDR = "_id desc";
	}

}
