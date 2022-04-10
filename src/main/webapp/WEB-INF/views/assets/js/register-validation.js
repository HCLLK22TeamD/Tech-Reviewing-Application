function registerValidate() { 
    const firstName = document.getElementById("firstName");
    const lastName = document.getElementById("lastName");
    const password = document.getElementById("password");
    const rePassword = document.getElementById("re-password");
    const email = document.getElementById("email");
    const mobile = document.getElementById("mobile");
    const genderM = document.getElementById("gender-male");
    const genderF = document.getElementById("gender-female");
    const accountType = document.getElementById("role");

    const isValidFistName = firstName.value.trim().length > 0;
    const isValidLastName = lastName.value.trim().length > 0;
    const isValidPass = password.value.trim().length > 0 && (password.value.trim().length > 4 && password.value.trim().length < 12);
    const isMatchPass = password.value === rePassword.value;
    const isValidGender = genderM.checked || genderF.checked;
    const isValidAccType = accountType.value != 0;

    const emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    const isValidEmail = emailRegex.test(email.value.trim());
    
    const mobileRegex = /^[0-9]\d{9}$/;
    const isValidMobile = mobileRegex.test(mobile.value.trim());
    
    console.log(isValidFistName, isValidLastName, isValidPass, isMatchPass, isValidEmail, isValidMobile,isValidGender);

    if (isValidFistName && isValidLastName && isValidPass && isMatchPass && isValidEmail && isValidMobile &&isValidGender && isValidAccType) {
        alert("Congrats... you are succefully logged in.");
        return true;

    } else {
        !isValidFistName ? firstName.classList.add("is-invalid") : firstName.classList.remove("is-invalid");
        !isValidLastName ? lastName.classList.add("is-invalid") : lastName.classList.remove("is-invalid");
        !isValidPass ? password.classList.add("is-invalid") : password.classList.remove("is-invalid");
        !isMatchPass ? rePassword.classList.add("is-invalid") : rePassword.classList.remove("is-invalid");
        !isValidEmail ? email.classList.add("is-invalid") : email.classList.remove("is-invalid");
        !isValidMobile ? mobile.classList.add("is-invalid") : mobile.classList.remove("is-invalid");
        !isValidGender ? genderM.classList.add("is-invalid") : genderM.classList.remove("is-invalid");
        !isValidGender ? genderF.classList.add("is-invalid") : genderF.classList.remove("is-invalid");
        !isValidAccType ? accountType.classList.add("is-invalid") : accountType.classList.remove("is-invalid");
    }
    return false;
    
}