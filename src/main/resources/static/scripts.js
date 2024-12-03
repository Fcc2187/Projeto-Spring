const BASE_URL = 'http://localhost:8080';

// Função para buscar listas de games
function fetchGameLists() {
  fetch(`${BASE_URL}/lists`)
    .then(response => response.json())
    .then(data => {
      const gameListsUl = document.getElementById('gameLists');
      gameListsUl.innerHTML = '';
      data.forEach(list => {
        const li = document.createElement('li');
        li.textContent = list.name;
        const button = document.createElement('button');
        button.textContent = 'Ver Jogos';
        button.onclick = () => fetchGamesFromList(list.id);
        li.appendChild(button);
        gameListsUl.appendChild(li);
      });
    });
}

// Função para buscar jogos de uma lista específica
function fetchGamesFromList(listId) {
  fetch(`${BASE_URL}/lists/${listId}/games`)
    .then(response => response.json())
    .then(data => {
      const gamesUl = document.getElementById('games');
      gamesUl.innerHTML = '';
      data.forEach(game => {
        const li = document.createElement('li');
        
        const gameLink = document.createElement('a');
        gameLink.href = `game-details.html?gameId=${game.id}`;

        const img = document.createElement('img');
        img.src = game.imgUrl;
        img.alt = game.title; 
    
        const title = document.createElement('span');
        title.textContent = game.title;
        
        gameLink.appendChild(img);
        li.appendChild(gameLink);  
        li.appendChild(title);     

        gamesUl.appendChild(li);   
      });
    });
}

// Função para buscar detalhes de um jogo
function fetchGameDetails(gameId) {
  fetch(`${BASE_URL}/games/${gameId}`)
    .then(response => response.json())
    .then(data => {
      document.getElementById('gameImage').src = data.imgUrl;
      document.getElementById('gameTitle').textContent = data.title;
      document.getElementById('gameDescription').textContent = data.shortDescription;
      document.getElementById('gameReleaseDate').textContent = data.year;
    });
}
