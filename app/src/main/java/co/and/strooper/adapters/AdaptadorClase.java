package co.and.strooper.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import co.and.strooper.R;
import co.and.strooper.clases.AvatarVo;

public class AdaptadorClase extends RecyclerView.Adapter<AdaptadorClase.ViewHolderAvatar> {

    List<AvatarVo> listaAvatars;
    View vista;

    public AdaptadorClase(List<AvatarVo> listaAvatars) {
        this.listaAvatars = listaAvatars;
    }



    @NonNull
    @Override
    public ViewHolderAvatar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_avatar,parent,false);
        return new ViewHolderAvatar(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAvatar holder, int position) {
        //va consiguiendo cada pocision y la imprime
        holder.imgAvatar.setImageResource(listaAvatars.get(position).getAvatarId());

    }

    @Override
    public int getItemCount() {
        //numero de Items que va a regresar
        return listaAvatars.size();
    }

    public class ViewHolderAvatar extends RecyclerView.ViewHolder {
        //instanciamos los graficos
        CardView cardAvatar;
        ImageView imgAvatar;
        TextView barraSeleccion;
        public ViewHolderAvatar(@NonNull View itemView) {
            super(itemView);
            cardAvatar = itemView.findViewById(R.id.cardAvatar);
            imgAvatar = itemView.findViewById(R.id.idAvatar);
            barraSeleccion = itemView.findViewById(R.id.barraSeleccionId);
        }
    }
}
