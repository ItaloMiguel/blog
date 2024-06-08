function showSlide(container, slides, index) {
    if (index >= slides.length) {
        index = 0;
    } else if (index < 0) {
        index = slides.length - 1;
    }
    const offset = -index * 100;
    container.style.transform = `translateX(${offset}%)`;
    return index;
}

export default function setupNavigation(prevButton, nextButton, container, slides) {
    let currentIndex = 0;

    prevButton.addEventListener('click', function () {
        currentIndex = showSlide(container, slides, currentIndex - 1);
    });

    nextButton.addEventListener('click', function () {
        currentIndex = showSlide(container, slides, currentIndex + 1);
    });

    // Show the initial slide
    currentIndex = showSlide(container, slides, currentIndex);
}