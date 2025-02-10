package com.example.recycleviewwithkotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(private var products : ArrayList<Product>,private var users:ArrayList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        
        val PRODUCT_VIEW_TYPE = 1
        val USER_VIEW_TYPE = 2
    
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var txtViewProductTitle : TextView
        private lateinit var txtViewProductPrice : TextView
        private lateinit var imgView1 : ImageView

        init {
            txtViewProductTitle = itemView.findViewById(R.id.txtViewProductTitle)
            txtViewProductPrice = itemView.findViewById(R.id.txtViewProductPrice)
            imgView1 = itemView.findViewById(R.id.imgView1)

            txtViewProductTitle.setOnClickListener(View.OnClickListener {
                var intent : Intent = Intent(it.context,ProductDetailsActivity::class.java)
                val eachProduct = products[adapterPosition]
                intent.putExtra("product",eachProduct)
                itemView.context.startActivity(intent)

            })
        }
    }
    inner class UserViewHolder(itemView :View):RecyclerView.ViewHolder(itemView){
        private lateinit var txtViewUsername : TextView
        private lateinit var userImageView:ImageView
        init{
            txtViewUsername=itemView.findViewById(R.id.txtUserName)
            userImageView=itemView.findViewById(R.id.UserImageView)
        }
    }

    override fun getItemViewType(position: Int): Int {
        //To print two products and one user
        if ((position+1)%3 == 0) {
            return USER_VIEW_TYPE
        }
        return PRODUCT_VIEW_TYPE
    }
      //TO print one user and one product
       /* if(position%2==0){
            return PRODUCT_VIEW_TYPE
        }
        return USER_VIEW_TYPE
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == PRODUCT_VIEW_TYPE) {
            val layoutInflater = LayoutInflater.from(parent.context)
            val productView = layoutInflater.inflate(R.layout.product_view_holder, null)

            return ProductViewHolder(productView)
        }
        val layoutInflater = LayoutInflater.from(parent.context)
        val userView = layoutInflater.inflate(R.layout.user_view_holder,null)
        return UserViewHolder(userView)
        
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //To print two products and one user
        if (holder is ProductViewHolder) {
            var product = products[position-(position/3)]
            var txtViewProductTitle = holder.itemView.findViewById<TextView>(R.id.txtViewProductTitle)
            txtViewProductTitle.text = product.productTitle
            holder.itemView.findViewById<TextView>(R.id.txtViewProductPrice).text = " " + product.productPrice
            holder.itemView.findViewById<ImageView>(R.id.imgView1).setImageResource(R.drawable.ic_launcher_background)
        }else{
            var user = users[(position+2)/4]
            var txtViewUserName = holder.itemView.findViewById<TextView>(R.id.txtUserName)
            var userImage = holder.itemView.findViewById<ImageView>(R.id.UserImageView).setImageResource(R.drawable.profile)
            txtViewUserName.text=user.UserName
        }
    }


        //TO print one user and one product
        /* if (holder is ProductViewHolder) {
             var product = products[position/2]
             var txtViewProductTitle = holder.itemView.findViewById<TextView>(R.id.txtViewProductTitle)
             txtViewProductTitle.text = product.productTitle
             holder.itemView.findViewById<TextView>(R.id.txtViewProductPrice).text = " " + product.productPrice
             holder.itemView.findViewById<ImageView>(R.id.imgView1).setImageResource(R.drawable.ic_launcher_background)
         }else{
             var user = users[(position-1/2)]
             var txtViewUserName = holder.itemView.findViewById<TextView>(R.id.txtUserName)
             var userImage = holder.itemView.findViewById<ImageView>(R.id.UserImageView).setImageResource(R.drawable.profile)
             txtViewUserName.text=user.UserName
         }*/

    override fun getItemCount(): Int {
        return products.size+users.size
    }
}
