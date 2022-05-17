package com.agh.projectmianterm

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import org.w3c.dom.Text

class information : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        val btnalertinput = findViewById<Button>(R.id.btnalertinput)
        val txtac = findViewById<TextView>(R.id.txtacount)
        val txtfn = findViewById<TextView>(R.id.txtfn)
        val txtln = findViewById<TextView>(R.id.txtln)
        val txtfa = findViewById<TextView>(R.id.txtfa)
        val txtph = findViewById<TextView>(R.id.txtph)
        val txtge = findViewById<TextView>(R.id.txtge)
        val showchb1 = findViewById<TextView>(R.id.showchb1)
        val showchb2 = findViewById<TextView>(R.id.showchb2)
        val showchb3 = findViewById<TextView>(R.id.showchb3)
        val showchb4 = findViewById<TextView>(R.id.showchb4)


        btnalertinput.setOnClickListener {

            val builder = AlertDialog.Builder(this).create()
            val view = layoutInflater.inflate(R.layout.activity_inputalert, null)
            builder.setView(view)
            builder.show()

            //------------------------------------------------------

            val View = layoutInflater.inflate(R.layout.activity_inputalert, null)
            val sp = view.findViewById<Spinner>(R.id.sp_list)
            val edtsp = view.findViewById<TextView>(R.id.txtsp)
            val edtfname = view.findViewById<EditText>(R.id.edtext_name)
            val edtlname = view.findViewById<EditText>(R.id.edtext_lname)
            val edtfather = view.findViewById<EditText>(R.id.edtext_father)
            val edtphone = view.findViewById<EditText>(R.id.edtext_phone)
            val radiog = view.findViewById<RadioGroup>(R.id.ac_start_rg)
            val chb1 = view.findViewById<CheckBox>(R.id.chb1)
            val chb2 = view.findViewById<CheckBox>(R.id.chb2)
            val chb3 = view.findViewById<CheckBox>(R.id.chb3)
            val chb4 = view.findViewById<CheckBox>(R.id.chb4)
            val btnsub = view.findViewById<Button>(R.id.ac_start_btn_submit)
            val radiom = view.findViewById<RadioButton>(R.id.radio_men)
            val radiow = view.findViewById<RadioButton>(R.id.radio_women)

            radiog.setOnCheckedChangeListener { group, checkedId ->
                if (radiom.isChecked) {
                    txtge.setText(radiom.text)
                } else {
                    if (radiow.isChecked) {
                        txtge.setText(radiow.text)
                    }
                }
            }

            sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    edtsp.setText(resources.getStringArray(R.array.entries)[position])

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

            //--------------------------------------------------------

            btnsub.setOnClickListener {

                var chbdata1: String = ""
                var chbdata2: String = ""
                var chbdata3: String = ""
                var chbdata4: String = ""
                var chbdata: String = ""

                if (edtfname.text.toString().equals("") || edtlname.text.toString()
                        .equals("") || edtfather.text.toString().equals("") || edtphone.text.toString()
                        .equals("")
                ) {

                    Toast.makeText(
                        getApplicationContext(),
                        "تمام فیلد ها را پر کنید",
                        Toast.LENGTH_LONG
                    ).show();

                } else if (edtphone.text.length != 11 || !edtphone.text.startsWith("09")) {

                    Toast.makeText(getApplicationContext(), "شماره تلفن صحیح نیست!", Toast.LENGTH_LONG)
                        .show();

                } else if (radiog.checkedRadioButtonId == -1) {

                    Toast.makeText(getApplicationContext(), "جنسیت خود را مشخص کنید", Toast.LENGTH_LONG)
                        .show();

                } else if (edtsp.text == "نوع حساب را انتخاب کنید") {

                    Toast.makeText(
                        getApplicationContext(),
                        "نوع حساب کاربری خود را مشخص کنید",
                        Toast.LENGTH_LONG
                    ).show();

                } else if (!chb1.isChecked && !chb2.isChecked && !chb3.isChecked && !chb4.isChecked) {

                    Toast.makeText(
                        getApplicationContext(),
                        "علاقه مندی خود را مشخص کنید",
                        Toast.LENGTH_LONG
                    ).show();

                } else if (chb1.isChecked && !chb2.isChecked && !chb3.isChecked && !chb4.isChecked) {

                    Toast.makeText(
                        getApplicationContext(),
                        "حداقل دو علاقه مندی انتخاب کنید",
                        Toast.LENGTH_LONG
                    ).show();

                } else if (!chb1.isChecked && chb2.isChecked && !chb3.isChecked && !chb4.isChecked) {

                    Toast.makeText(
                        getApplicationContext(),
                        "حداقل دو علاقه مندی انتخاب کنید",
                        Toast.LENGTH_LONG
                    ).show();

                } else if (!chb1.isChecked && !chb2.isChecked && chb3.isChecked && !chb4.isChecked) {

                    Toast.makeText(
                        getApplicationContext(),
                        "حداقل دو علاقه مندی انتخاب کنید",
                        Toast.LENGTH_LONG
                    ).show();

                } else if (!chb1.isChecked && !chb2.isChecked && !chb3.isChecked && chb4.isChecked) {

                    Toast.makeText(
                        getApplicationContext(),
                        "حداقل دو علاقه مندی انتخاب کنید",
                        Toast.LENGTH_LONG
                    ).show();


                } else {

                    if (chb1.isChecked) {
                        chbdata1 += chb1.text
                    }
                    if (chb2.isChecked) {
                        chbdata2 += chb2.text
                    }
                    if (chb3.isChecked) {
                        chbdata3 += chb3.text
                    }
                    if (chb4.isChecked) {
                        chbdata4 += chb4.text
                    }

                    showchb1.text = chbdata1
                    showchb2.text = chbdata2
                    showchb3.text = chbdata3
                    showchb4.text = chbdata4

                    txtac.setText(edtsp.text)

                    txtfn.text = edtfname.text
                    txtln.text = edtlname.text
                    txtfa.text = edtfather.text
                    txtph.text = edtphone.text


                    builder.dismiss()

                }
            }

            builder.setCancelable(false)


        }
    }
}