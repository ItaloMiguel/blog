const header = document.querySelector("header")
const trocaTema = document.getElementById("change-theme")

trocaTema.addEventListener("click", changeTheme)

function changeTheme() {
    if (header.classList.contains("black")) {
        header.classList.remove("black")
        header.classList.add("white")
    } else {
        header.classList.remove("white")
        header.classList.add("black")
    }
}