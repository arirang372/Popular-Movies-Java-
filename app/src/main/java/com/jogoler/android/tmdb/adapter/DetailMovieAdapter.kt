package com.jogoler.android.tmdb.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.jogoler.android.tmdb.DetailMovieContract
import com.jogoler.android.tmdb.R
import com.jogoler.android.tmdb.pojo.Review
import com.jogoler.android.tmdb.pojo.Trailer
import com.squareup.picasso.Picasso
import java.util.*


/**
 * Created by Gilbert on 19/06/18.
 */

class DetailMovieAdapter(private val listener: DetailMovieContract.MovieListener) : RecyclerView.Adapter<DetailMovieAdapter.BaseViewHolder<*>>() {

    private val data: MutableList<Comparable<*>>

    companion object {
        private const val TYPE_TITLE = 0
        private const val TYPE_TRAILER = 1
        private const val TYPE_REVIEW = 2
    }

    init {
        data = ArrayList()
    }

    fun swapData(newData: List<Comparable<*>>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val context = parent.context
        return when (viewType) {
            TYPE_TITLE -> {
                val view = LayoutInflater.from(context).inflate(R.layout.title_list_content, parent, false)
                TitleViewHolder(view)
            }
            TYPE_TRAILER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.trailer_list_content, parent, false)
                TrailerViewHolder(view, listener, data)
            }
            TYPE_REVIEW -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.review_list_content, parent, false)
                ReviewViewHolder(view, listener, data)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = data[position]
        when (holder) {
            is TitleViewHolder -> holder.bind(element as String)
            is TrailerViewHolder -> holder.bind(element as Trailer)
            is ReviewViewHolder -> holder.bind(element as Review)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is String -> TYPE_TITLE
            is Trailer -> TYPE_TRAILER
            is Review -> TYPE_REVIEW
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T)
    }

    class TitleViewHolder(view: View) : BaseViewHolder<String>(view) {

        private val titleTextView = view.findViewById<TextView>(R.id.title_text_view)

        override fun bind(title: String) {
            titleTextView.text = title
        }
    }

    class TrailerViewHolder(private val view: View, private val listener: DetailMovieContract.MovieListener,
                            private val data: List<Comparable<*>>) : BaseViewHolder<Trailer>(view), View.OnClickListener {

        private val trailerListView = view.findViewById<LinearLayout>(R.id.trailer_list_linear_layout)
        private val titleTextView = view.findViewById<TextView>(R.id.trailer_title_text_view)
        private val trailerImageView = view.findViewById<ImageView>(R.id.thumbnail_trailer_image_view)

        override fun bind(trailer: Trailer) {
            val thumbnailUrl = "http://img.youtube.com/vi/" + trailer.key + "/0.jpg" // getKeyyy
            Picasso.with(view.context)
                    .load(thumbnailUrl)
                    .into(trailerImageView)
            titleTextView.text = trailer.name
            trailerListView!!.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val position = adapterPosition

            if (position < 0) {
                return
            }

            val trailer = data[position] as Trailer
            listener.onWatch(trailer, adapterPosition)
        }
    }

    class ReviewViewHolder(view: View, private val listener: DetailMovieContract.MovieListener,
                           private val data: List<Comparable<*>>) : BaseViewHolder<Review>(view), View.OnClickListener {
        private val reviewListView = view.findViewById<LinearLayout>(R.id.review_list_linear_layout)
        private val authorTextView = view.findViewById<TextView>(R.id.author_text_view)
        private val reviewTextView = view.findViewById<TextView>(R.id.review_text_view)

        override fun bind(review: Review) {
            authorTextView.text = review.author
            reviewTextView.text = review.content
            reviewListView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val position = adapterPosition

            if (position < 0) {
                return
            }

            val review = data[position] as Review
            listener.onRead(review, adapterPosition)
        }
    }
}
