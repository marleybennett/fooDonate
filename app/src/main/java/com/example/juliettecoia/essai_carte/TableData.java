package com.example.juliettecoia.essai_carte;

import android.provider.BaseColumns;

/**
 * Created by marleybennett on 8/3/16.
 */
public class TableData {

    public TableData(){}

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String USER_NAME = "user_name";
        public static final String USER_ORG = "user_org";
        public static final String USER_ADDRESS = "user_address";
        public static final String USER_PHONE = "user_phone";
        public static final String USER_EMAIL = "user_email";
        public static final String USER_PASS = "user_pass";
        public static final String USER_ACCPTDON = "user_accptdon";
        public static final String DATABASE_NAME = "user_info";
        public static final String TABLE_NAME = "reg_info";


    }
}
