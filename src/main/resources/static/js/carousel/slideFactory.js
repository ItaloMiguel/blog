export default function createSlide(slideData) {
    const slide = document.createElement('div');
    slide.classList.add('carousel-slide');

    // Se remover essa div, o botão de volta some.
    const slideBox = document.createElement('div');
    slideBox.classList.add('carousel-slideBox');
    slideBox.style.backgroundColor = slideData.backgroundColor

    const title = document.createElement('h2');
    title.textContent = slideData.title;

    const text = document.createElement('p');
    text.textContent = slideData.text;

    const link = document.createElement('a');
    link.href = slideData.link;
    link.textContent = 'leia mais';
    link.target = '_blank';

    slideBox.appendChild(title);
    slideBox.appendChild(text);
    slideBox.appendChild(link);

    slide.appendChild(slideBox);

    return slide;
}