package vn.udn.ute.week08.a126tlttd01_2415053122203
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var tilTen: TextInputLayout
    private lateinit var tilQt: TextInputLayout
    private lateinit var tilCk: TextInputLayout
    private lateinit var edtTen: TextInputEditText
    private lateinit var edtQt: TextInputEditText
    private lateinit var edtCk: TextInputEditText
    private lateinit var txtKetQua: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tilTen = findViewById(R.id.tilTen)
        tilQt = findViewById(R.id.tilQt)
        tilCk = findViewById(R.id.tilCk)
        edtTen = findViewById(R.id.edtTen)
        edtQt = findViewById(R.id.edtQt)
        edtCk = findViewById(R.id.edtCk)
        txtKetQua = findViewById(R.id.txtKetQua)

        findViewById<Button>(R.id.btnKiemTra).setOnClickListener {
            val ten = edtTen.text.toString().trim()
            val qt = HocPhanHelper.docDiem(edtQt.text.toString())
            val ck = HocPhanHelper.docDiem(edtCk.text.toString())

            tilTen.error = if (HocPhanHelper.kiemTraTen(ten)) null else "Tên dài 1-40 ký tự"
            tilQt.error = if (qt != null) null else "QT là số 0-10, dùng dấu chấm"
            tilCk.error = if (ck != null) null else "CK là số 0-10, dùng dấu chấm"

            if (tilTen.error != null || qt == null || ck == null) {
                txtKetQua.text = ""
                return@setOnClickListener
            }
            hienKetQua(ten, qt, ck)
        }
    }

    private fun hienKetQua(ten: String, qt: Double, ck: Double) {
        val t = HocPhanHelper.tinhT(qt, ck)
        val kl = HocPhanHelper.phanLoai(t, ck)
        fun f(x: Double) = "%.2f".format(java.util.Locale.US, x)
        txtKetQua.text = "Tên: $ten\nQT: ${f(qt)}\nCK: ${f(ck)}\nT: ${f(t)}\nKết luận: $kl"
    }
}