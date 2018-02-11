"use strict";

// Initialize a new game
function newGame() {
    // Perform the initial GET to the /game endpoint to retrieve the initial cards
    $.get( "/game/", function( data ) {
        $('.new-game').removeClass('hidden');
        $('.active-game').removeClass('hidden');
        $('.completed-game').addClass('hidden');
        processPlayerData(data);
    });
}

function action(name) {
    $.post( "/game/", { action: name } )
        .done(function(data) {
            processPlayerData(data);
            if(data.status == "PLAYERS_TURN") {
                $('.new-game').addClass('hidden');
            } else {
                processBankData(data);
                $('.active-game').addClass('hidden');
                $('.completed-game').removeClass('hidden');
                let result;
                if(data.status == 'PLAYER_WINS') {
                    result = "You have won!";
                } else {
                    result = "You have lost.";
                }
                $('.result').html(result);
            }
        });
}

function processPlayerData(data) {
    $('.player-cards').html(concatCards(data.player.cards));
    $('.player-value').html(data.player.value);
}

function processBankData(data) {
    $('.bank-cards').html(concatCards(data.bank.cards));
    $('.bank-value').html(data.bank.value);
}

function concatCards(cards) {
    let cardsStr = "";
    for(let i = 0; i < cards.length; i++) {
        if(i != 0) {
            cardsStr += ', ';
        }
        cardsStr += cards[i].string;
    }
    return cardsStr;
}

newGame();