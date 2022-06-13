package com.kirabium.mynews.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class NewsResponse : Serializable {
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("totalResults")
    @Expose
    var totalResults = 0

    @SerializedName("articles")
    @Expose
    var articles: List<Article>? = null

    fun withStatus(status: String?): NewsResponse {
        this.status = status
        return this
    }

    fun withTotalResults(totalResults: Int): NewsResponse {
        this.totalResults = totalResults
        return this
    }

    fun withArticles(articles: List<Article>?): NewsResponse {
        this.articles = articles
        return this
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(NewsResponse::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("status")
        sb.append('=')
        sb.append(if (status == null) "<null>" else status)
        sb.append(',')
        sb.append("totalResults")
        sb.append('=')
        sb.append(totalResults)
        sb.append(',')
        sb.append("articles")
        sb.append('=')
        sb.append(if (articles == null) "<null>" else articles)
        sb.append(',')
        if (sb[sb.length - 1] == ',') {
            sb.setCharAt(sb.length - 1, ']')
        } else {
            sb.append(']')
        }
        return sb.toString()
    }

    override fun hashCode(): Int {
        var result = 1
        result = result * 31 + totalResults
        result = result * 31 + if (articles == null) 0 else articles.hashCode()
        result = result * 31 + if (status == null) 0 else status.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) {
            return true
        }
        if (other is NewsResponse == false) {
            return false
        }
        val rhs = other
        return totalResults == rhs.totalResults && (articles === rhs.articles || articles != null && articles == rhs.articles) && (status === rhs.status || status != null && status == rhs.status)
    }

    companion object {
        private const val serialVersionUID = -1419848899775288779L
    }
}
