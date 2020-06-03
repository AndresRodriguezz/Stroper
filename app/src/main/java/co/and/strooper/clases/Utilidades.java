package co.and.strooper.clases;

import java.util.ArrayList;

import co.and.strooper.R;

public class Utilidades {
    //Inicializamos variable de topoArrylist de AvatarVo nulo;
    public static ArrayList<AvatarVo> listaAvatares = null;
    public static int avatarIdSeleccion = 0;
    public static AvatarVo avatarSeleccion = null;


    public static void obtenerListaAvatares(){
        //metodo para obtener y asignar los datos del arraylist que es la listaAvatares

        listaAvatares = new ArrayList<AvatarVo>();



        //Se llena Arraylist

        listaAvatares.add(new AvatarVo(1, R.drawable.avatar1,"Avatar1"));
        listaAvatares.add(new AvatarVo(2, R.drawable.avatar2,"Avatar2"));
        listaAvatares.add(new AvatarVo(3, R.drawable.avatar3,"Avatar3"));
        listaAvatares.add(new AvatarVo(4, R.drawable.avatar4,"Avatar4"));
        listaAvatares.add(new AvatarVo(5, R.drawable.avatar5,"Avatar5"));
        listaAvatares.add(new AvatarVo(6, R.drawable.avatar6,"Avatar6"));
        listaAvatares.add(new AvatarVo(7, R.drawable.avatar7,"Avatar7"));
        listaAvatares.add(new AvatarVo(8, R.drawable.avatar8,"Avatar8"));
        listaAvatares.add(new AvatarVo(9, R.drawable.avatar9,"Avatar9"));
        listaAvatares.add(new AvatarVo(10, R.drawable.avatar10,"Avatar10"));
        listaAvatares.add(new AvatarVo(11, R.drawable.avatar11,"Avatar11"));
        listaAvatares.add(new AvatarVo(12, R.drawable.avatar12,"Avatar12"));
        listaAvatares.add(new AvatarVo(13, R.drawable.avatar13,"Avatar13"));
        listaAvatares.add(new AvatarVo(14, R.drawable.avatar14,"Avatar14"));
        listaAvatares.add(new AvatarVo(15, R.drawable.avatar15,"Avatar15"));
        listaAvatares.add(new AvatarVo(16, R.drawable.avatar16,"Avatar16"));
        listaAvatares.add(new AvatarVo(17, R.drawable.avatar17,"Avatar17"));
        listaAvatares.add(new AvatarVo(18, R.drawable.avatar18,"Avatar18"));
        listaAvatares.add(new AvatarVo(19, R.drawable.avatar19,"Avatar19"));
        listaAvatares.add(new AvatarVo(20, R.drawable.avatar20,"Avatar20"));
        listaAvatares.add(new AvatarVo(21, R.drawable.avatar21,"Avatar21"));
        listaAvatares.add(new AvatarVo(22, R.drawable.avatar22,"Avatar22"));
        listaAvatares.add(new AvatarVo(23, R.drawable.avatar23,"Avatar23"));
        listaAvatares.add(new AvatarVo(24, R.drawable.avatar24,"Avatar24"));
        listaAvatares.add(new AvatarVo(25, R.drawable.avatar25,"Avatar25"));
        listaAvatares.add(new AvatarVo(26, R.drawable.avatar26,"Avatar26"));
        listaAvatares.add(new AvatarVo(27, R.drawable.avatar27,"Avatar27"));

    }
}
