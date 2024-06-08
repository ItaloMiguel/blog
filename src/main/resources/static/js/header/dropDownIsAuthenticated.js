// Is Authenticated
document.addEventListener('DOMContentLoaded', function() {
    const dropbtn_isAuthenticated = document.getElementById('dropbtn-isAuthenticated');
    const dropdownContent_isAuthenticated = document.getElementById('dropdown-content-isAuthenticated');

    dropbtn_isAuthenticated.addEventListener('click', function() {
        dropdownContent_isAuthenticated.style.display = dropdownContent_isAuthenticated.style.display === 'block' ? 'none' : 'block';
    });

    window.addEventListener('click', function(event) {
        if (!event.target.matches('.dropbtn')) {
            if (dropdownContent_isAuthenticated.style.display === 'block') {
                dropdownContent_isAuthenticated.style.display = 'none';
            }
        }
    });
});