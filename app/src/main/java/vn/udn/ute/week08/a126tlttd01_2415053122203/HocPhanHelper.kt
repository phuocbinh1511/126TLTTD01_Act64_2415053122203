package vn.udn.ute.week08.s2415053122203

object HocPhanHelper {
    const val NGUONG_D = 5.5
    private val soThuc = Regex("^\\d+(\\.\\d+)?$")

    fun kiemTraTen(ten: String): Boolean = ten.trim().length in 1..40

    fun docDiem(s: String): Double? {
        val t = s.trim()
        if (!soThuc.matches(t)) return null
        val d = t.toDoubleOrNull() ?: return null
        return if (d.isFinite() && d in 0.0..10.0) d else null
    }

    fun tinhT(qt: Double, ck: Double): Double = 0.4 * qt + 0.6 * ck

    fun phanLoai(t: Double, ck: Double): String =
        if (t >= NGUONG_D && ck >= 3.0) "Đạt" else "Chưa đạt"
}