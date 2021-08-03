package layout

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import layout.Estructura_BBDD.Estructura_BBDD.SQL_CREATE_ENTRIES
import layout.Estructura_BBDD.Estructura_BBDD.SQL_DELETE_ENTRIES

class BBDD_Helper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    //Método para la creación de la base de datos
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    //Método para actualizar la base de datos
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }


    companion object {
        //La versión de la base de datos
        const val DATABASE_VERSION = 1

        //Aquí es donde se dará nombre a la base de datos
        const val DATABASE_NAME = "Base_vaqueros.db"
    }

}
