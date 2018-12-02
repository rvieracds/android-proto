package com.roviera.vitalsigngenerallayoutkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import java.util.*

import android.support.design.widget.Snackbar
import android.support.v4.view.ViewPager


import kotlin.math.roundToInt
import android.support.v4.app.FragmentPagerAdapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.TitlePageIndicator;


class MainActivity : AppCompatActivity() {

    //internal var llfirstline: LinearLayout? = null;
    /*private var llsecondline: LinearLayout? = null;
    private var llageInputs: LinearLayout? = null;
    private var llhtInputs: LinearLayout? = null;
    private var llsexInputs: LinearLayout? = null;

    private var ageButton: Button? = null;
    private var dobButton: Button? = null;
    private var sexButton: Button? = null;
    private var htButton: Button? = null;
    private var femaleButton: Button? = null;
    private var maleButton: Button? = null;
    private var unspecifiedButton: Button? = null;

    private var yearsInput: EditText? = null;
    private var monthsInput: EditText? = null;
    private var daysInput: EditText? = null;
    private var feetInput: EditText? = null;
    private var inchInput: EditText? = null;
    private var cmInput: EditText? = null;*/

    //internal var datePickerDialog: DatePickerDialog? = null;

    var centimeters = 0.0;
    var globalFeet = 0.0;
    var globalInch = 0.0;
    var dobM = "";
    var dobD = "";
    var dobY = "";
    var dobDate = "";


    // GET LINEARLAYOUT INSTANCES
    lateinit var llfirstline: LinearLayout
    lateinit var llsecondline: LinearLayout
    lateinit var llageInputs: LinearLayout
    lateinit var lldobInputs: LinearLayout
    lateinit var llhtInputs: LinearLayout
    lateinit var llsexInputs: LinearLayout

    // GET BUTTONS INSTANCES
    lateinit var ageButton: Button
    lateinit var dobButton: Button
    lateinit var sexButton: Button
    lateinit var htButton: Button

    // GET AGE INPUTS INSTANCES
    lateinit var yearsInput: EditText;
    lateinit var monthsInput: EditText;
    lateinit var daysInput: EditText;

    // GET DOB INPUTS INSTANCES
    lateinit var dobYearInput: EditText;
    lateinit var dobMonthInput: EditText;
    lateinit var dobDayInput: EditText;

    // GET HEIGHT INPUTS INSTANCES
    lateinit var feetInput: EditText;
    lateinit var inchInput: EditText;
    lateinit var cmInput: EditText;

    // GET SEX BUTTONS INSTANCES
    lateinit var femaleButton: Button;
    lateinit var maleButton: Button;
    lateinit var unspecifiedButton: Button;

    lateinit  var circleIndicator: CirclePageIndicator

    //lateinit var mViewPager: ViewPager;
    //lateinit var adapterViewPager: FragmentPagerAdapter;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mViewPager = findViewById(R.id.viewPager)
        //mViewPager.adapter = ViewPagerAdapter(this)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        if (viewPager != null) {
            //Set the pager with an adapter
            val adapter = ViewPagerAdapter(supportFragmentManager)
            viewPager.adapter = adapter

            //Bind the title indicator to the adapter
            circleIndicator = findViewById<CirclePageIndicator>(R.id.indicator)
            circleIndicator.setViewPager(viewPager)
        }


        // ==========================================================================================================

        // GET LINEARLAYOUT INSTANCES
        llfirstline = findViewById(R.id.llfirstline) as LinearLayout
        llsecondline = findViewById(R.id.llsecondline) as LinearLayout
        llageInputs = findViewById(R.id.llageInputs) as LinearLayout
        lldobInputs = findViewById(R.id.lldobInputs) as LinearLayout
        llhtInputs = findViewById(R.id.llhtInputs) as LinearLayout
        llsexInputs = findViewById(R.id.llsexInputs) as LinearLayout

        // GET BUTTONS INSTANCES
        ageButton = findViewById(R.id.ageButton) as Button
        dobButton = findViewById(R.id.dobButton) as Button
        sexButton = findViewById(R.id.sexButton) as Button
        htButton = findViewById(R.id.htButton) as Button

        // GET AGE INPUTS INSTANCES
        yearsInput = findViewById(R.id.yearsInput) as EditText
        monthsInput = findViewById(R.id.monthsInput) as EditText
        daysInput = findViewById(R.id.daysInput) as EditText

        // GET DOB INPUTS INSTANCES
        dobYearInput = findViewById(R.id.dobYearInput) as EditText
        dobMonthInput = findViewById(R.id.dobMonthInput) as EditText
        dobDayInput = findViewById(R.id.dobDayInput) as EditText

        // GET HEIGHT INPUTS INSTANCES
        feetInput = findViewById(R.id.feetInput) as EditText
        inchInput = findViewById(R.id.inchInput) as EditText
        cmInput = findViewById(R.id.cmInput) as EditText

        // GET SEX BUTTONS INSTANCES
        femaleButton = findViewById(R.id.femaleButton) as Button
        maleButton = findViewById(R.id.maleButton) as Button
        unspecifiedButton = findViewById(R.id.unspecifiedButton) as Button

        // SET VISIBLE MAIN BUTTONS (AGE - DOB - SEX - HT)
        llfirstline.visibility = View.VISIBLE
        llsecondline.visibility = View.VISIBLE


        // =======================================================================================
        //                                  LISTENERS SECTION
        // =======================================================================================

        // LISTENER AGE BUTTON
        ageButton.setOnClickListener {
            llfirstline.visibility = View.GONE
            llageInputs.visibility = View.VISIBLE
        }

        yearsInput.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val strValue = yearsInput.text.toString()
                if (strValue != "") {
                    ageButton.text = "$strValue years old"
                    ageButton.setBackgroundResource(R.drawable.input_left_rounded_corners_gradient)

                    monthsInput.setText("")
                    daysInput.setText("")
                } else {
                    ageButton.text = "Age"
                    ageButton.setBackgroundResource(R.drawable.button_left_rounded_corners_gradient)
                    monthsInput.setText("")
                    daysInput.setText("")
                }
                llfirstline.visibility = View.VISIBLE
                llageInputs.visibility = View.GONE
                return@OnKeyListener true
            }
            false
        })

        yearsInput.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                val strValue = yearsInput.text.toString()
                if (strValue != "") {
                    yearsInput.setText("")
                }
            }
        }

        monthsInput.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val strValue = monthsInput.text.toString()
                if (strValue != "") {
                    ageButton.text = "$strValue months old"
                    ageButton.setBackgroundResource(R.drawable.input_left_rounded_corners_gradient)
                    yearsInput.setText("")
                    daysInput.setText("")
                } else {
                    ageButton.text = "Age"
                    ageButton.setBackgroundResource(R.drawable.button_left_rounded_corners_gradient)
                    yearsInput.setText("")
                    daysInput.setText("")
                }
                llfirstline.visibility = View.VISIBLE
                llageInputs.visibility = View.GONE
                return@OnKeyListener true
            }
            false
        })

        monthsInput.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                val strValue = monthsInput.text.toString()
                if (strValue != "") {
                    monthsInput.setText("")
                }
            }
        }

        daysInput.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val strValue = daysInput.text.toString()
                if (strValue != "") {
                    ageButton.text = "$strValue days old"
                    ageButton.setBackgroundResource(R.drawable.input_right_rounded_corners_gradient)
                    yearsInput.setText("")
                    monthsInput.setText("")
                } else {
                    ageButton.text = "Age"
                    ageButton.setBackgroundResource(R.drawable.button_left_rounded_corners_gradient)
                    yearsInput.setText("")
                    monthsInput.setText("")
                }
                llfirstline.visibility = View.VISIBLE
                llageInputs.visibility = View.GONE
                return@OnKeyListener true
            }
            false
        })

        daysInput.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                val strValue = daysInput.text.toString()
                if (strValue != "") {
                    daysInput.setText("")
                }
            }
        }

        // ==========================================================================================
        // ==========================================================================================

        // LISTENER DOB BUTTON
        dobButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

            llfirstline.visibility = View.GONE
            lldobInputs.visibility = View.VISIBLE

        }

        dobMonthInput.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val strValue = dobMonthInput.text.toString()
                if (strValue != "") {
                    dobM = strValue
                    dobButton.text = updateDOB(dobY, dobM, dobD)
                    dobButton.setBackgroundResource(R.drawable.input_left_rounded_corners_gradient)

                    //dobDayInput.requestFocus();
                } else {
                    dobButton.text = "DOB"
                    dobButton.setBackgroundResource(R.drawable.button_left_rounded_corners_gradient)
                }
                updateAge()
                //llfirstline.visibility = View.VISIBLE
                //lldobInputs.visibility = View.GONE
                return@OnKeyListener true
            }
            false
        })

        dobMonthInput.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                val strValue = dobMonthInput.text.toString()
                if (strValue != "") {
                    dobMonthInput.setText("")
                }
            }
        }

        dobDayInput.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val strValue = dobDayInput.text.toString()
                if (strValue != "") {
                    dobD = strValue
                    dobButton.text = updateDOB(dobY, dobM, dobD)
                    dobButton.setBackgroundResource(R.drawable.input_left_rounded_corners_gradient)

                    //dobYearInput.requestFocus();
                } else {
                    dobButton.text = "DOB"
                    dobButton.setBackgroundResource(R.drawable.button_left_rounded_corners_gradient)
                }
                updateAge()
                //llfirstline.visibility = View.VISIBLE
                //lldobInputs.visibility = View.GONE
                return@OnKeyListener true
            }
            false
        })

        dobDayInput.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                val strValue = dobDayInput.text.toString()
                if (strValue != "") {
                    dobDayInput.setText("")
                }
            }
        }

        dobYearInput.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val strValue = dobYearInput.text.toString()
                if (strValue != "") {
                    dobY = strValue
                    dobButton.text = updateDOB(dobY, dobM, dobD)
                    dobButton.setBackgroundResource(R.drawable.input_left_rounded_corners_gradient)

                    //dobYearInput.setShowSoftInputOnFocus(false)
                } else {
                    dobButton.text = "DOB"
                    dobButton.setBackgroundResource(R.drawable.button_left_rounded_corners_gradient)
                }
                updateAge()
                llfirstline.visibility = View.VISIBLE
                lldobInputs.visibility = View.GONE
                return@OnKeyListener true
            }
            false
        })

        dobYearInput.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                val strValue = dobYearInput.text.toString()
                if (strValue != "") {
                    dobYearInput.setText("")
                }
            }
        }

        // LISTENER DOB BUTTON
        /*dobButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this@MainActivity,
                R.style.TimePickerTheme,
                DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                    val correctMonth = month + 1;
                    dobButton.text = day.toString() + ". " + correctMonth + ". " + year
                    dobButton.setBackgroundResource(R.drawable.input_right_rounded_corners_gradient)

                    val dob = Calendar.getInstance()
                    val today = Calendar.getInstance()
                    dob.set(year, month, day)

                    // Get the represented date in milliseconds
                    val millis1 = dob.getTimeInMillis()
                    val millis2 = today.getTimeInMillis()

                    // Calculate difference in milliseconds
                    val diff = millis2 - millis1

                    // Calculate difference in days, months and years
                    val diffDays = diff / (24 * 60 * 60 * 1000)
                    val diffMonths = diffDays / 30
                    val diffYears = diffDays / 365

                    if ((diffYears) > 0) {
                        ageButton.text = "$diffYears years old"
                        yearsInput.setText("$diffYears years old")
                        monthsInput.setText("")
                        daysInput.setText("")
                    } else if ((diffMonths) > 0) {
                        ageButton.text = "$diffMonths months old"
                        monthsInput.setText("$diffMonths months old")
                        yearsInput.setText("")
                        daysInput.setText("")
                    } else {
                        ageButton.text = "$diffDays days old"
                        daysInput.setText("$diffDays days old")
                        yearsInput.setText("")
                        monthsInput.setText("")
                    }
                    ageButton.setBackgroundResource(R.drawable.input_left_rounded_corners_gradient)
                }, year, month, dayOfMonth
            )
            datePickerDialog.show()
        }*/

        // ==========================================================================================
        // ==========================================================================================

        // LISTENER SEX BUTTON
        sexButton.setOnClickListener {
            llsecondline.visibility = View.GONE
            llsexInputs.visibility = View.VISIBLE
        }

        femaleButton.setOnClickListener {
            llsecondline.visibility = View.VISIBLE
            llsexInputs.visibility = View.GONE
            sexButton.text = "Female"
            sexButton.setBackgroundResource(R.drawable.input_left_rounded_corners_gradient)
        }

        maleButton.setOnClickListener {
            llsecondline.visibility = View.VISIBLE
            llsexInputs.visibility = View.GONE
            sexButton.text = "Male"
            sexButton.setBackgroundResource(R.drawable.input_left_rounded_corners_gradient)
        }

        unspecifiedButton.setOnClickListener {
            llsecondline.visibility = View.VISIBLE
            llsexInputs.visibility = View.GONE
            sexButton.text = "Unspecified"
            sexButton.setBackgroundResource(R.drawable.input_left_rounded_corners_gradient)
        }

        // ==========================================================================================
        // ==========================================================================================

        // LISTENER HT BUTTON
        htButton.setOnClickListener {
            llsecondline.visibility = View.GONE
            llhtInputs.visibility = View.VISIBLE
        }

        cmInput.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val strValue = cmInput.text.toString()
                if (strValue != "") {
                    htButton.text = "$strValue cm"
                    htButton.setBackgroundResource(R.drawable.input_right_rounded_corners_gradient)

                    val dCentimeter = java.lang.Double.valueOf(strValue)
                    val feetPart = Math.floor(dCentimeter / 2.54 / 12).toInt()
                    val inchesPart = Math.ceil(dCentimeter / 2.54 - feetPart * 12).toInt()

                    feetInput.setText(feetPart.toString() + " ft")
                    inchInput.setText(inchesPart.toString() + " in")
                } else {
                    htButton.text = "Ht."
                    htButton.setBackgroundResource(R.drawable.button_right_rounded_corners_gradient)
                    feetInput.setText("")
                    inchInput.setText("")
                }
                llsecondline.visibility = View.VISIBLE
                llhtInputs.visibility = View.GONE
                return@OnKeyListener true
            }
            false
        })

        cmInput.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                val strValue = cmInput.text.toString()
                if (strValue != "") {
                    cmInput.setText("")
                }
            }
        }

        feetInput.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val strValue = feetInput.text.toString()
                val strValue2 = inchInput.text.toString()
                if (strValue != "" || strValue2 != "") {
                    if (strValue != "" && strValue2 != "") {
                        htButton.text = "$strValue ft $strValue2 in"
                        globalFeet = (java.lang.Double.valueOf(strValue))*30.48
                        centimeters = globalFeet + globalInch;
                        cmInput.setText(centimeters.roundToInt().toString() + " cm")
                    } else if (strValue != "") {
                        htButton.text = "$strValue ft"
                        globalFeet = (java.lang.Double.valueOf(strValue))*30.48
                        centimeters = globalFeet + globalInch;
                        cmInput.setText(centimeters.roundToInt().toString() + " cm")
                    } else if (strValue2 != "") {
                        htButton.text = "$strValue2 in"
                        globalFeet = (java.lang.Double.valueOf(strValue))*30.48
                        centimeters = globalFeet + globalInch;
                        cmInput.setText(centimeters.roundToInt().toString() + " cm")
                    }

                    htButton.setBackgroundResource(R.drawable.input_right_rounded_corners_gradient)

                    inchInput.requestFocus();

                } else {
                    htButton.text = "Ht."
                    htButton.setBackgroundResource(R.drawable.button_right_rounded_corners_gradient)
                    cmInput.setText("")
                    inchInput.setText("")
                    centimeters = 0.0
                }
                //llsecondline.visibility = View.VISIBLE
                //llhtInputs.visibility = View.GONE
                return@OnKeyListener true
            }
            false
        })

        feetInput.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                val strValue = feetInput.text.toString()
                if (strValue != "") {
                    feetInput.setText("")
                }
            }
        }

        inchInput.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val strValue = inchInput.text.toString()
                val strValue2 = feetInput.text.toString()
                if (strValue != "" || strValue2 != "") {
                    if (strValue != "" && strValue2 != "") {
                        htButton.text = "$strValue2 ft $strValue in"
                        globalInch = (java.lang.Double.valueOf(strValue))*2.54
                        centimeters = globalFeet + globalInch;
                        cmInput.setText(centimeters.roundToInt().toString() + " cm")
                    } else if (strValue != "") {
                        htButton.text = "$strValue in"
                        globalInch = (java.lang.Double.valueOf(strValue))*2.54
                        centimeters = globalFeet + globalInch;
                        cmInput.setText(centimeters.roundToInt().toString() + " cm")
                    } else if (strValue2 != "") {
                        htButton.text = "$strValue2 ft"
                        globalInch = (java.lang.Double.valueOf(strValue))*2.54
                        centimeters = globalFeet + globalInch;
                        cmInput.setText(centimeters.roundToInt().toString() + " cm")
                    }

                    htButton.setBackgroundResource(R.drawable.input_right_rounded_corners_gradient)

                } else {
                    htButton.text = "Ht."
                    htButton.setBackgroundResource(R.drawable.button_right_rounded_corners_gradient)
                    feetInput.setText("")
                    cmInput.setText("")
                    centimeters = 0.0
                }
                llsecondline.visibility = View.VISIBLE
                llhtInputs.visibility = View.GONE
                return@OnKeyListener true
            }
            false
        })

        inchInput.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                val strValue = inchInput.text.toString()
                if (strValue != "") {
                    inchInput.setText("")
                }
            }
        }























        // FLOATING ACTION BUTTON ACTION
        /*val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()*/
        //}
    }

    private fun updateDOB(year: String, month: String, day: String): String {
        dobDate = month + ". " + day + ". " + year
        return dobDate
    }

    private fun updateAge() {
        if (dobY != "" && dobM != ""  && dobD != "" ) {
            dobButton.text = dobDate
            dobButton.setBackgroundResource(R.drawable.input_right_rounded_corners_gradient)

            val dob = Calendar.getInstance()
            val today = Calendar.getInstance()
            dob.set(dobY.toInt(), dobM.toInt(), dobD.toInt())

            // Get the represented date in milliseconds
            val millis1 = dob.getTimeInMillis()
            val millis2 = today.getTimeInMillis()

            // Calculate difference in milliseconds
            val diff = millis2 - millis1

            // Calculate difference in days, months and years
            val diffDays = diff / (24 * 60 * 60 * 1000)
            val diffMonths = diffDays / 30
            val diffYears = diffDays / 365

            if ((diffYears) > 0) {
                ageButton.text = "$diffYears years old"
                yearsInput.setText("$diffYears years old")
                monthsInput.setText("")
                daysInput.setText("")
            } else if ((diffMonths) > 0) {
                ageButton.text = "$diffMonths months old"
                monthsInput.setText("$diffMonths months old")
                yearsInput.setText("")
                daysInput.setText("")
            } else {
                ageButton.text = "$diffDays days old"
                daysInput.setText("$diffDays days old")
                yearsInput.setText("")
                monthsInput.setText("")
            }
            ageButton.setBackgroundResource(R.drawable.input_left_rounded_corners_gradient)



            llfirstline.visibility = View.VISIBLE
            lldobInputs.visibility = View.GONE
        }
    }


}

