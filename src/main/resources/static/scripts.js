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
        const img = document.createElement('img');
        img.src = game.imgUrl; // Supondo que "imageUrl" está no DTO
        const title = document.createElement('span');
        title.textContent = game.title; // Supondo que "title" está no DTO
        const button = document.createElement('button');
        button.textContent = 'Detalhes';
        button.onclick = () => showGameDetails(game.id);
        li.appendChild(img);
        li.appendChild(title);
        li.appendChild(button);
        gamesUl.appendChild(li);
      });
    });
}

// Função para redirecionar para a página de detalhes do jogo
function showGameDetails(gameId) {
  window.location.href = `game-details.html?gameId=${gameId}`;
}

function fetchGameDetails(gameId) {
  fetch(`${BASE_URL}/games/${gameId}`)
    .then(response => response.json())
    .then(data => {
      document.getElementById('gameImage').src = data.imgUrl;
      document.getElementById('gameTitle').textContent = data.title;
      document.getElementById('gameDescription').textContent = data.description;
      document.getElementById('gameReleaseDate').textContent = data.releaseDate;
      document.getElementById('gameGenre').textContent = data.genre;
    });
}
