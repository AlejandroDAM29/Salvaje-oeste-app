package layout

import android.provider.BaseColumns

//En esta clase se establece la estructura básica de la base de datos.
class Estructura_BBDD {

    //En este bloque creo un objeto de clase para almacenar la estructura de la tabla
    object Estructura_BBDD: BaseColumns {
        //Nombre de la tabla. El nombre de la tabla no puede tener espacios
        const val TABLE_NAME = "Datos_vaqueros"
        //Nombres de columnas
        const val NOMBRE_COLUMNA1 = "Edad"
        const val NOMBRE_COLUMNA2 = "Nombre"



        //Este código permite la creación de la tabla en base a la estructura anterior
        const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${Estructura_BBDD.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${Estructura_BBDD.NOMBRE_COLUMNA1} TEXT," +
                    "${Estructura_BBDD.NOMBRE_COLUMNA2} TEXT)"

         //Esta línea permite eliminar la tabla creada si existe
         const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${Estructura_BBDD.TABLE_NAME}"
    }//Fin del objeto de clase

}