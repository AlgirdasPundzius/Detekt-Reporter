package pm.algirdas.detekt.reports

import com.google.gson.annotations.SerializedName

data class CodeQualityReport(
        @SerializedName("description")
        val description: String,
        @SerializedName("fingerprint")
        val fingerprint: String,
        @SerializedName("location")
        val location: Location
) {
    data class Location(
            @SerializedName("lines")
            val lines: Lines,
            @SerializedName("path")
            val path: String
    ) {
        data class Lines(
                @SerializedName("begin")
                val begin: Int,
                @SerializedName("end")
                val end: Int
        )
    }
}