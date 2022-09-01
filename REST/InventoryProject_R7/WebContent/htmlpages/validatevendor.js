function validatevendorform() {
		var frm = document.myform;
		var ino = frm.invNo;
		var iamt = frm.invAmount;
		var mcode = frm.dateOfInv;
		var quant = frm.quantity;
		var vid = frm.vendorId;
		var vname = frm.vendorName;
		var vadd = frm.vendorAddress;
		var ph = frm.phone;
		var sp1 = document.getElementById("sp1");
		var sp2 = document.getElementById("sp2");
		var spDate = document.getElementById("spDate");
		var sp4 = document.getElementById("sp4");
		//var sp5 = document.getElementById("sp5");
		var sp6 = document.getElementById("sp6");
		var sp7 = document.getElementById("sp7");
		var sp8 = document.getElementById("sp8");
		var po=  frm.poReference;
		sp1.style.visibility = "hidden";
		sp2.style.visibility = "hidden";
	//	sp3.style.visibility = "hidden";
		sp4.style.visibility = "hidden";
		//sp5.style.visibility = "hidden";
		sp6.style.visibility = "hidden";
		sp7.style.visibility = "hidden";
		sp8.style.visibility = "hidden";
		var status = true;
		if (ino.value == "") {
			sp1.innerHTML = "This field should not be empty";
			sp1.style.color = "red";
			sp1.style.visibility = "visible";
			status = false;
		} 
		
		else if (po.value == "") {
			sp2.innerHTML = "This field should not be empty";
			sp2.style.color = "red";
			sp2.style.visibility = "visible";
			status = false;
		}
		else if (iamt.value == "") {
			sp2.innerHTML = "This field should not be empty";
			sp2.style.color = "red";
			sp2.style.visibility = "visible";
			status = false;
		} else if (mcode.value == "") {
			spDate.innerHTML = "This field should not be empty";
			spDate.style.color = "red";
			spDate.style.visibility = "visible";
			status = false;
		}  else if (quant.value == "") {
			sp4.innerHTML = "This field should not be empty";
			sp4.style.color = "red";
			sp4.style.visibility = "visible";
			status = false;
		} /* else if (vid.value == "") {
			sp5.innerHTML = "This field should not be empty";
			sp5.style.color = "red";
			sp5.style.visibility = "visible";
			status = false;
		}  */else if (vname.value == "") {
			sp6.innerHTML = "This field should not be empty";
			sp6.style.color = "red";
			sp6.style.visibility = "visible";
			status = false;
		} else if (vadd.value == "") {
			sp7.innerHTML = "This field should not be empty";
			sp7.style.color = "red";
			sp7.style.visibility = "visible";
			status = false;
		} else if (ph.value == "") {
			sp8.innerHTML = "This field should not be empty";
			sp8.style.color = "red";
			sp8.style.visibility = "visible";
			status = false;
		} else if (isNaN(ph.value)) {
			sp8.innerHTML = "Only digits are allowed";
			sp8.style.color = "red";
			sp8.style.visibility = "visible";
			status = false;
		}
		return status;
}