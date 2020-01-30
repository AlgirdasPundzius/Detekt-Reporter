package pm.algirdas.detekt.reports

import com.google.gson.GsonBuilder
import io.gitlab.arturbosch.detekt.api.ConsoleReport
import io.gitlab.arturbosch.detekt.api.Detektion

class CustomConsoleReport : ConsoleReport() {

    override fun render(detektion: Detektion): String? {
        val smells = detektion.findings.flatMap { it.value }
        val reports =
                smells.map { CodeQualityReport(it.message, it.hashCode().toString(),
                        CodeQualityReport.Location(CodeQualityReport.Location.Lines(it.entity.location.source.line, it.entity.location.source.line),
                                "/app/" + it.entity.location.file.substringAfter("/app/"))) }
        val gson = GsonBuilder().setPrettyPrinting().create()
        return gson.toJson(reports)
    }
}
