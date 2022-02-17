package com.uta.caizaguanokevinsupletorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.uta.caizaguanokevinsupletorio.Datos.UsuariosHelperKDCC;

public class RegistroActivityKDCC extends AppCompatActivity {

    EditText editTextCedula, editTextNombre, editTextContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_kdcc);

        editTextCedula = findViewById(R.id.editTextTextCedulaRegistro);
        editTextContrasenia = findViewById(R.id.editTextTextContraseñaRegistro);
        editTextNombre = findViewById(R.id.editTextTextNombreRegistro);
    }

    public  void registrar(View view)
    {
        String cedula = editTextCedula.getText().toString();
        String contrasenia = editTextContrasenia.getText().toString();
        String nombre = editTextNombre.getText().toString();

        if (validarContrasenia(contrasenia)){

            if (validarCedula(cedula)){
                try {
                    UsuariosHelperKDCC usuariohelper = new UsuariosHelperKDCC(this, "usuariosDB",null,1);
                    SQLiteDatabase sql = usuariohelper.getWritableDatabase();
                    ContentValues lstvalores = new ContentValues();
                    lstvalores.put("Cedula",cedula);
                    lstvalores.put("Contrasenia",contrasenia);
                    lstvalores.put("Nombre",nombre);
                    sql.insert("Usuarios", null,lstvalores);
                    sql.close();
                    Toast.makeText(this,"Insertado con exito", Toast.LENGTH_SHORT).show();
                    finish();

                }catch (Exception ex){
                    Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }else {
                Toast.makeText(this, "Ingrese una cedula valida", Toast.LENGTH_SHORT).show();
            }

        }


    }


    public  Boolean validarContrasenia ( String contraseña){


        if (contraseña.length() > 4 ){

            boolean mayuscula = false;
            boolean numero = false;
            boolean minuscula = false;
            boolean caracter = false;
            char c;

            char[] especiales = {'?','@','#','$','%','^','&','*','?','_','~','.','|','-','[','}','+','{',']',';',':'};
            for (int j =0 ; j < especiales.length; j++){
                for (int h =0 ; h < contraseña.length(); h++){
                    if (contraseña.charAt(h) == especiales[j] ){
                        caracter = true;
                    }
                }
            }


            for (int i=0 ; i< contraseña.length();i++){
                c = contraseña.charAt(i);
                if (Character.isDigit(c))
                    numero = true;
                if (Character.isUpperCase(c))
                    mayuscula = true;
                if (Character.isLowerCase(c))
                    minuscula= true;

            }

            if (mayuscula && numero && minuscula && caracter){
                return  true;
            } else{
                Toast.makeText(getApplicationContext(), "Debe contener mayuscula, minuscula,numero y  caracter especial", Toast.LENGTH_SHORT).show();
                return  false;
            }

        }else {
            Toast.makeText(getApplicationContext(), "La contraseña es de  4 a 10 caracteres", Toast.LENGTH_SHORT).show();
            return  false;
        }

    }


    public boolean validarCedula(String cedula) {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() == 10) {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            cedulaCorrecta = false;
        }
        return  cedulaCorrecta;
    }

}