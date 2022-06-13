package com.kirabium.mynews.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Article : Serializable {
    @SerializedName("source")
    @Expose
    var source: Source? = null

    @SerializedName("author")
    @Expose
    var author: Any? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("urlToImage")
    @Expose
    var urlToImage: String? = null

    @SerializedName("publishedAt")
    @Expose
    var publishedAt: String? = null

    @SerializedName("content")
    @Expose
    var content: String? = null

    fun withSource(source: Source?): Article {
        this.source = source
        return this
    }

    fun withAuthor(author: Any?): Article {
        this.author = author
        return this
    }

    fun withTitle(title: String?): Article {
        this.title = title
        return this
    }

    fun withDescription(description: String?): Article {
        this.description = description
        return this
    }

    fun withUrl(url: String?): Article {
        this.url = url
        return this
    }

    fun withUrlToImage(urlToImage: String?): Article {
        this.urlToImage = urlToImage
        return this
    }

    fun withPublishedAt(publishedAt: String?): Article {
        this.publishedAt = publishedAt
        return this
    }

    fun withContent(content: String?): Article {
        this.content = content
        return this
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(Article::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("source")
        sb.append('=')
        sb.append(if (source == null) "<null>" else source)
        sb.append(',')
        sb.append("author")
        sb.append('=')
        sb.append(if (author == null) "<null>" else author)
        sb.append(',')
        sb.append("title")
        sb.append('=')
        sb.append(if (title == null) "<null>" else title)
        sb.append(',')
        sb.append("description")
        sb.append('=')
        sb.append(if (description == null) "<null>" else description)
        sb.append(',')
        sb.append("url")
        sb.append('=')
        sb.append(if (url == null) "<null>" else url)
        sb.append(',')
        sb.append("urlToImage")
        sb.append('=')
        sb.append(if (urlToImage == null) "<null>" else urlToImage)
        sb.append(',')
        sb.append("publishedAt")
        sb.append('=')
        sb.append(if (publishedAt == null) "<null>" else publishedAt)
        sb.append(',')
        sb.append("content")
        sb.append('=')
        sb.append(if (content == null) "<null>" else content)
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
        result = result * 31 + if (publishedAt == null) 0 else publishedAt.hashCode()
        result = result * 31 + if (author == null) 0 else author.hashCode()
        result = result * 31 + if (urlToImage == null) 0 else urlToImage.hashCode()
        result = result * 31 + if (description == null) 0 else description.hashCode()
        result = result * 31 + if (source == null) 0 else source.hashCode()
        result = result * 31 + if (title == null) 0 else title.hashCode()
        result = result * 31 + if (url == null) 0 else url.hashCode()
        result = result * 31 + if (content == null) 0 else content.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) {
            return true
        }
        if (other !is Article) {
            return false
        }
        val rhs = other
        return (publishedAt === rhs.publishedAt || publishedAt != null && publishedAt == rhs.publishedAt) && (author === rhs.author || author != null && author == rhs.author) && (urlToImage === rhs.urlToImage || urlToImage != null && urlToImage == rhs.urlToImage) && (description === rhs.description || description != null && description == rhs.description) && (source === rhs.source || source != null && source == rhs.source) && (title === rhs.title || title != null && title == rhs.title) && (url === rhs.url || url != null && url == rhs.url) && (content === rhs.content || content != null && content == rhs.content)
    }
}
