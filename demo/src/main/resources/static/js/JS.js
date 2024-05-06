document.addEventListener('DOMContentLoaded', function () {
    const searchInput = document.getElementById('searchInput');
    const prodSearch = document.getElementById('prodsearch');

    searchInput.addEventListener('keyup', function () {
        const searchTerm = searchInput.value.trim();
        if (searchTerm.length === 0) {
            prodSearch.style.display = 'none';
            prodSearch.innerHTML = '';
            return;
        }

        fetch(/search?term=${encodeURIComponent(searchTerm)})
            .then(response => response.json())
            .then(data => {
                prodSearch.style.display = 'block';
                prodSearch.innerHTML = '';
                if (data.length === 0) {
                    prodSearch.innerHTML = '<div>No results found!</div>';
                    return;
                }
                data.forEach(item => {
                    const div = document.createElement('div');
                    div.textContent = item.name;
                    div.addEventListener('click', () => {
                        searchInput.value = item.name; // Ensures the correct text is set
                        prodSearch.style.display = 'none';
                    });
                    prodSearch.appendChild(div);
                });
            })
            .catch(error => {
                console.error('Error:', error);
                prodSearch.innerHTML = '<div>Error fetching results.</div>';
            });
    });
});