import createSlide from "./slideFactory.js";
import setupNavigation from "./navigation.js";

export default document.addEventListener('DOMContentLoaded', function () {
    const slidesData = [
        { title: 'Sobre o site', text: 'O site tem o objetivo de compartilhar e ensinar sobre ciências exatas e da terra de forma divertida, com aniamções e desenhos. Além disso com o código aberto para o público poder pegar e melhorar.', link: '', backgroundColor: 'rgb(226, 216, 16)' },
        { title: 'O que é código aberto?', text: 'Código aberto é um jeito de produzir software sem fins lucrativos que permite a qualquer pessoa modificar e compartilhar. Para mais detalhes acesse essa página ', link: 'https://pt.wikipedia.org/wiki/Software_de_c%C3%B3digo_aberto', backgroundColor: 'rgb(217, 19, 138)' },
        { title: 'Como acho o código do projeto?', text: 'Código do software disponível nesse', link: '', backgroundColor: 'rgb(18, 164, 217)'}
    ];
    const container = document.getElementById('carousel-slides');

    slidesData.forEach(slideData => {
        const slide = createSlide(slideData);
        container.appendChild(slide);
    });

    const slides = document.querySelectorAll('.carousel-slide');
    const prevButton = document.getElementById('prevBtn');
    const nextButton = document.getElementById('nextBtn');

    setupNavigation(prevButton, nextButton, container, slides);
});