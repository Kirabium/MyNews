package com.kirabium.mynews.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Source : Serializable {
    @SerializedName("id")
    @Expose
    var id: Any? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    fun withId(id: Any?): Source {
        this.id = id
        return this
    }

    fun withName(name: String?): Source {
        this.name = name
        return this
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(Source::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("id")
        sb.append('=')
        sb.append(if (id == null) "<null>" else id)
        sb.append(',')
        sb.append("name")
        sb.append('=')
        sb.append(if (name == null) "<null>" else name)
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
        result = result * 31 + if (name == null) 0 else name.hashCode()
        result = result * 31 + if (id == null) 0 else id.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) {
            return true
        }
        if (other is Source == false) {
            return false
        }
        val rhs = other
        return (name === rhs.name || name != null && name == rhs.name) && (id === rhs.id || id != null && id == rhs.id)
    }

    companion object {
        private const val serialVersionUID = 6761927321822356477L
    }
}
