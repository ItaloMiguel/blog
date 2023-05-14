const windowProfile = document.getElementById("profile-photo")


windowProfile.addEventListener("click", loadDropDown)

function loadDropDown() {
if (windowProfile.classList.contains("active")) {
        windowProfile.classList.remove("active")
    } else {
        windowProfile.classList.add("active")
    }
}