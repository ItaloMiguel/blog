const body = document.querySelector("body")
const header = document.querySelector("header")
const div = document.querySelectorAll("div")
const button = document.querySelectorAll("button")
const input = document.querySelectorAll("input")

const varChangeTheme = document.getElementById("change-theme")

varChangeTheme.addEventListener("click", changeTheme)

function changeTheme() {
    if (body.classList.contains("dark-mode")) {
        header.classList.remove("dark-mode")
        header.classList.add("light-mode")

        div.forEach.classList.remove("dark-mode")
        div.forEach.classList.add("light-mode")

        button.forEach.classList.remove("dark-mode")
        button.forEach.classList.add("light-mode")

        input.forEach.classList.remove("dark-mode")
        input.forEach.classList.add("light-mode")

    } else {
        header.classList.remove("light-mode")
        header.classList.add("dark-mode")

        div.forEach.classList.remove("light-mode")
        div.forEach.classList.add("dark-mode")

        button.forEach.classList.remove("light-mode")
        button.forEach.classList.add("dark-mode")

        input.forEach.classList.remove("light-mode")
        input.forEach.classList.add("dark-mode")
    }
}