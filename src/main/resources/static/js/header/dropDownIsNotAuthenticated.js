// Is not Authenticated
document.addEventListener('DOMContentLoaded', function() {
    const dropbtn_isNotAuthenticated = document.getElementById('dropbtn-isNotAuthenticated');
    const dropdownContent_isAuthenticated = document.getElementById('dropdown-content-isNotAuthenticated');

    dropbtn_isNotAuthenticated.addEventListener('click', function() {
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