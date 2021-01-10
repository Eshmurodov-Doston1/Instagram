package com.example.instagram.fragments

import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.instagram.R
import com.example.instagram.adpters.RvAdapter
import com.example.instagram.adpters.RvAdapterEnd
import com.example.instagram.models.ImageClass
import com.example.instagram.models.NewsClass
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_first.view.*
class FirstFragment : Fragment(){
    lateinit var root:View
    lateinit var listImage: ArrayList<ImageClass>
    lateinit var pdpNewsList: ArrayList<NewsClass>
    lateinit var rvAdapter: RvAdapter
    lateinit var rvAdapterEnd: RvAdapterEnd
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_first, container, false)
        loadData()
        loadDataNew()
         setHasOptionsMenu(true)
         Picasso.get().load("https://yt3.ggpht.com/ytc/AAUvwnhJadO7VnYGM3CXDmtPsK90RkfLNwnzcoFx__SqQQ=s900-c-k-c0x00ffffff-no-rj").into(root.image)
        root.menyu.setOnClickListener {
            var dialog = ItemDialogFragment()
            dialog.show(fragmentManager!!,"exampleFragment")
        }
        root.q_1.setOnClickListener {
            var dialog2 =DialogItemFragment2()
            dialog2.show(fragmentManager!!,"exampleFragment")
        }
        root.card1.setOnClickListener{
        var dialog3 = DilalogFragment3()
            dialog3.show(fragmentManager!!,"exampleFragment")

        }
        root.card3_text.setOnClickListener {
          var kontakt = Kontakt()
            kontakt.show(fragmentManager!!,"exampleFragment")
        }

        root.card2.setOnClickListener{
           var secondFragment = SecondFragment()
            fragmentManager?.beginTransaction()?.addToBackStack(secondFragment.toString())?.replace(R.id.container,secondFragment)?.commit()
        }
        rvAdapter = RvAdapter(listImage)
        root.rv_view.adapter = rvAdapter

        rvAdapterEnd = RvAdapterEnd(pdpNewsList, object : RvAdapterEnd.MyItemClickListener {
            override fun OnItemClick(position: Int, newsClass: NewsClass) {
                var thrideFragment = ThrideFragment.newInstance(pdpNewsList[position].imgURL!!)

                //
                fragmentManager?.beginTransaction()?.
                addToBackStack(thrideFragment.toString())?.
                replace(R.id.container, thrideFragment)?.
                commit()

            }
        })
        root.rv_and.adapter = rvAdapterEnd
        return root
    }

    private fun loadDataNew() {
        pdpNewsList = ArrayList()
        pdpNewsList.add(NewsClass("https://telegra.ph/file/9df75b782a1f4d8f622bb.png"))
        pdpNewsList.add(NewsClass("https://telegra.ph/file/9ea13fcd06e821d1e47c7.png"))
        pdpNewsList.add(NewsClass("https://telegra.ph/file/c12df4a1ff3b1c04ba26c.png"))

        pdpNewsList.add(NewsClass("https://telegra.ph/file/59bd92547becc4e21a98b.png"))
        pdpNewsList.add(NewsClass("https://telegra.ph/file/d05b164bd2619465bf9bc.png"))
        pdpNewsList.add(NewsClass("https://telegra.ph/file/0a9d28c33a8b1fe05e55f.png"))

        pdpNewsList.add(NewsClass("https://telegra.ph/file/05e327165b5c11b0a573a.png"))
        pdpNewsList.add(NewsClass("https://telegra.ph/file/877cb754b681921c4e09c.png"))
        pdpNewsList.add(NewsClass("https://telegra.ph/file/635d9a7c9d269dfc7163d.png"))

        pdpNewsList.add(NewsClass("https://telegra.ph/file/1872da48815728da0e686.png"))
        pdpNewsList.add(NewsClass("https://telegra.ph/file/d91b42458513b71db3b96.png"))
        pdpNewsList.add(NewsClass("https://telegra.ph/file/2afc9a601d2ad16106048.png"))

        pdpNewsList.add(NewsClass("https://telegra.ph/file/bf01de35081fe05d8f78c.png"))
        pdpNewsList.add(NewsClass("https://telegra.ph/file/51f7883763a77d01fb2f3.png"))
        pdpNewsList.add(NewsClass("https://telegra.ph/file/1ac47d2bee3b576316bcd.png"))
    }

    private fun loadData() {
        listImage = ArrayList()
        listImage.add(ImageClass(R.drawable.ic_ebook,"Darslar"))
        listImage.add(ImageClass(R.drawable.ic_map_location,"Manzil"))
        listImage.add(ImageClass(R.drawable.ic_question,"Savol&Javob"))
        listImage.add(ImageClass(R.drawable.ic_phone_call,"Aloqa"))
        listImage.add(ImageClass(R.drawable.ic_online_course,"Kurslar"))
    }







    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menyu,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemId = item.itemId
        when(itemId){
            R.id.add -> {
                Toast.makeText(root.context, "Instagram", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)

    }




}