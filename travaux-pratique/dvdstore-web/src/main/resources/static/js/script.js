
fetch('movie')
    .then(res => res.json())
    .then(res => {
        var invoiceListNode = document.getElementById('movie-list');
        invoiceListNode.innerHTML = "";

        var table = document.createElement("table");
        table.setAttribute("border","1");
        invoiceListNode.appendChild(table);

        //  partie de création du tableau
        res.forEach((movie, index) => {
            var tr = document.createElement("tr");
            tr.style.animationDelay = `${index * 0.1}s`; // Pour un effet d'animation en cascade
            table.appendChild(tr);

            var td = document.createElement("td");
            var text = document.createTextNode(`${movie.title}`);
            td.appendChild(text);
            tr.appendChild(td);

            td = document.createElement("td");
            // Ajout d'un badge pour le genre
            var genreSpan = document.createElement("span");
            genreSpan.textContent = movie.genre;
            genreSpan.style.backgroundColor = getGenreColor(movie.genre);
            genreSpan.style.padding = "5px 10px";
            genreSpan.style.borderRadius = "20px";
            genreSpan.style.fontSize = "0.8em";
            td.appendChild(genreSpan);
            tr.appendChild(td);

            td = document.createElement("td");
            var button = document.createElement("button");
            button.setAttribute("type","button");
            button.onclick = function() {
                showDetail(`${movie.id}`);
            };
            text = document.createTextNode("Détails");
            button.appendChild(text);
            td.appendChild(button);
            tr.appendChild(td);
        });

    });

// Fonction helper pour les couleurs de genre
function getGenreColor(genre) {
    const genreColors = {
        'Action': '#ff5252',
        'Comédie': '#ffab40',
        'Drame': '#ff4081',
        'Science-Fiction': '#40c4ff',
        'Horreur': '#7c4dff',
        'Romance': '#ff80ab',
        'Thriller': '#b388ff',
        'Animation': '#64ffda'
    };
    return genreColors[genre] || '#607d8b';
}


function showDetail(id){
    fetch("movie/"+id)
        .then(res => res.json())
        .then(res => {
            var invoiceDetailNode = document.getElementById('movie-detail');
            invoiceDetailNode.innerHTML = "";

            var p = document.createElement("p");
            // Dans la fonction showDetail, ajoutez une image de film fictive
            p = document.createElement("p");
            var img = document.createElement("img");
            img.src = `https://via.placeholder.com/300x450/1a1a2e/ffcc00?text=${encodeURIComponent(res.title)}`;
            img.alt = res.title;
            img.style.width = '100%';
            img.style.borderRadius = '8px';
            img.style.marginBottom = '15px';
            img.style.boxShadow = '0 4px 8px rgba(0,0,0,0.3)';
            p.appendChild(img);
            // fin
            invoiceDetailNode.insertBefore(p, invoiceDetailNode.firstChild);
            var text = document.createTextNode(`Titre: ${res.title}`);
            p.appendChild(text);
            invoiceDetailNode.appendChild(p);

            p = document.createElement("p");
            text = document.createTextNode(`Genre: ${res.genre}`);
            p.appendChild(text);
            invoiceDetailNode.appendChild(p);

            p = document.createElement("p");
            text = document.createTextNode(`Description: ${res.description}`);
            p.appendChild(text);
            invoiceDetailNode.appendChild(p);

            p = document.createElement("p");
            text = document.createTextNode(`Main actor: ${res.mainActor.firstName} ${res.mainActor.lastName}`);
            p.appendChild(text);
            invoiceDetailNode.appendChild(p);

            p = document.createElement("p");
            var sum = res.reviews.map((a) => a.mark).reduce((a, b) => a + b, 0);
            var avg = (sum / res.reviews.length) || 0;
            text = document.createTextNode(`Mark: ${avg}/5`);
            p.appendChild(text);
            invoiceDetailNode.appendChild(p);


        });
}
