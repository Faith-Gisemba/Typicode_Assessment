package apis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gisey.typicode.databinding.UserlistBinding

class UsersAdapter(var userList:List<User>): RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding= UserlistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var currentUser=userList[position]
        val binding=holder.binding
        binding.tvId.text=currentUser.id.toString()
        binding.tvtitle.text=currentUser.title
        binding.tvUser.text=currentUser.userid.toString()
        binding.tvBody.text=currentUser.body
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}
class UserViewHolder(var binding: UserlistBinding): RecyclerView.ViewHolder(binding.root){

}