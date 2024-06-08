document.addEventListener('DOMContentLoaded', function() {
    const dropbtn = document.getElementById('dropbtn');
    const dropdownContent = document.getElementById('dropdown-content');

    dropbtn.addEventListener('click', function() {
        dropdownContent.style.display = dropdownContent.style.display === 'block' ? 'none' : 'block';
    });

    window.addEventListener('click', function(event) {
        if (!event.target.matches('.dropbtn')) {
            if (dropdownContent.style.display === 'block') {
                dropdownContent.style.display = 'none';
            }
        }
    });
});
