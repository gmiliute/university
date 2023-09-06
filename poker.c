#include <stdio.h>
#include <time.h>
#include <ctype.h>
#include <stdlib.h>
#include <stdbool.h>
#include <assert.h>
#define FALSE 0 // for defining flushs or straights
#define TRUE 1
FILE * fptr;
typedef struct
{
int coins;
}Results;
void printGreeting();
int getBet();
void getFirstHand(int cardRank[], int cardSuit[]);
char getSuit(int suit);
char getRank(int rank);
void getFinalHand(int cardRank[], int cardSuit[], int finalRank[], int finalSuit[], int ranksInHand[], int suitsInHand[]);
int analyzeHand(int ranksInHand[], int suitsInHand[]);
void saveToFile(Results *stats, int n);
void uploadFromFile(Results **stats, int *n);
bool createFile();
bool openFile();
//-*********************************
int main()
{
int bet, bank = 100, i, cardRank[13], cardSuit[5], finalRank[5], finalSuit[5], ranksInHand[13], suitsInHand[5], winnings, n = 0;
time_t period;
char suit, rank, stillPlay;

    Results *stats = NULL;
    if(!openFile()){
        assert(!openFile());
        n=0;
    }else{
        uploadFromFile(&stats,&n);
    }
    printGreeting();
    do  // Loop for every new game
    {
        bet = getBet();
        srand(time(&period));
        getFirstHand(cardRank, cardSuit);
        printf("Your hand: \n");
            for (i = 0; i < 5; i++)
            {
                suit = getSuit(cardSuit[i]);
                rank = getRank(cardRank[i]);
                printf("Card no %d: %c%c\n", i + 1, rank, suit);
            }
            for (i = 0; i < 4; i++)
            {
                suitsInHand[i] = 0;
            }
            for (i = 0; i < 14; i++)
            {
                ranksInHand[i] = 0;
            }

                    getFinalHand(cardRank, cardSuit, finalRank, finalSuit, ranksInHand, suitsInHand);
                    printf("Your final hand: \n");

                    for (i = 0; i < 5; i++)
                    {
                        suit = getSuit(finalSuit[i]);
                        rank = getRank(finalRank[i]);
                        printf("Card #%d: %c%c\n", i + 1, rank, suit);
                    }

                            winnings = analyzeHand(ranksInHand, suitsInHand);
                            printf("You have won %d coins!\n", bet * winnings);
                            bank = bank - bet + (bet * winnings);
                            printf("\nYour new bank is now %d coins. \n", bank);
                            printf("\nWould you like to play one more match? ");
                            scanf(" %c", &stillPlay);
    }
while (toupper(stillPlay) == 'Y');
saveToFile(stats, n);
free(stats);
return 0;
}
//-*****************************************************
void printGreeting()
{
    printf("****************************************************\n");
    printf("********Welcome to the Miliute's poker club!********\n");
    printf("****************************************************\n\n");
    printf("\t\t\tRULES:\n\n");
    printf("+Your bank is 100 poker coins, from whom you will make a preflop bet [1 - 100] coins \n");
    printf("+You will be dealt with 5 cards, and then you will make a decision \n");
    printf("which cards throw away or keep in the final hand\n");
    printf("+The goals is to make the best possible hand and win the bank!\n");
    printf("\n!Winnings formula: bet multiplied by:\n");
    printf("\nHigh card\t\t\t0 coins");
    printf("\nPair\t\t\t\t1 coin");
    printf("\nTwo pairs\t\t\t2 coins");
    printf("\nThree of a kind\t\t\t4 coins");
    printf("\nStraight\t\t\t5 coins");
    printf("\nFlush\t\t\t\t8 coins");
    printf("\nFull House\t\t\t10 coins");
    printf("\nFour of a Kind\t\t\t25 coins");
    printf("\nStraight Flush\t\t\t50 coins");
    printf("\n\nLet's start the poker match!!\n\n");
}
//-********************************************************
int getBet() // to do: validacija su raidemis ir etc
{
int bet;
    do
    {
        printf("What is your bid for this round? (Enter a number in interval [1 - 100] \n");
        printf("or enter 0 to instantly quit the Miliute's poker club: ");
        scanf("%d", &bet);
            if (bet > 0 && bet < 101)
            {
                return (bet); }
            else if (bet == 0)
            {
                printf("\n*****************************");
                printf("\nSee you next time! Byeeeeeee\n");
                printf("*****************************\n\n");
                printf("Nobody is always a winner, and anybody who says he is, \n");
                printf("is either a liar or doesn't play poker -Amarillo Slim");
                printf("\n****************************************************");
                //to do: B dalis, ismesti stats sitoje vietoje
                exit(0);
            }
            else
            {
                printf("\n\nTry again!\n");
            }
    }
    while ((bet < 0) || (bet > 100));
}
//-*************************************************
void getFirstHand(int cardRank[], int cardSuit[])
{
    int i, j, cardDup;
        for (i = 0; i < 5; i++)
        {
            cardDup = 0;
                do
                {
                    cardRank[i] = (rand() % 13);
                    cardSuit[i] = (rand() % 4);
                        for (j = 0; j < i; j++)
                        {
                            if ((cardRank[i] == cardRank[j])&&(cardSuit[i] == cardSuit[j]))
                            {
                            cardDup = 1;
                            }
                        }
                }
                while (cardDup == 1);
        }
}
//-***********************************************
char getSuit(int suit)
{
    switch (suit)
    {
        case 0:
        return ('c');

        case 1:
        return ('d');

        case 2:
        return ('h');

        case 3:
        return ('s');
    }
}
char getRank(int rank)
{
    switch (rank)
    {
        case 0:
        return ('A');

        case 1:
        return ('2');

        case 2:
        return ('3');

        case 3:
        return ('4');

        case 4:
        return ('5');

        case 5:
        return ('6');

        case 6:
        return ('7');

        case 7:
        return ('8');

        case 8:
        return ('9');

        case 9:
        return ('T');

        case 10:
        return ('J');

        case 11:
        return ('Q');

        case 12:
        return ('K');
    }
}
//-************************************************
void getFinalHand(int cardRank[], int cardSuit[], int finalRank[], int finalSuit[], int ranksInHand[], int suitsInHand[])
{
int i, j, cardDup;
char suit, rank, decision;
    for (i = 0; i < 5; i++) //todo: validacija
    {
        suit = getSuit(cardSuit[i]);
        rank = getRank(cardRank[i]);
        printf("Do you want to keep card no %d: %c%c?", i + 1, rank, suit);
        printf("\nYour decision: (Y/N): ");
        scanf(" %c", &decision);
            if (toupper(decision) == 'Y')
            {
            finalRank[i] = cardRank[i];
            finalSuit[i] = cardSuit[i];
            ranksInHand[finalRank[i]]++;
            suitsInHand[finalSuit[i]]++;
            continue;
            }
            else if (toupper(decision) == 'N')
            {
                cardDup = 0;
                do
                {
                cardDup = 0;
                finalRank[i] = (rand() % 13);
                finalSuit[i] = (rand() % 4);

                    for (j=0; j < 5; j++)
                    {
                        if ((finalRank[i] == cardRank[j]) && (finalSuit[i] == cardSuit[j]))
                        {
                            cardDup = 1;
                        }
                    }
                    for (j = 0; j < i; j++)
                    {
                        if ((finalRank[i] == finalRank[j]) &&  (finalSuit[i] == finalSuit[j]))
                        {
                            cardDup = 1;
                        }
                   }
                }
                while (cardDup == 1);
                    ranksInHand[finalRank[i]]++;
                    suitsInHand[finalSuit[i]]++;
            }
    }
}
//-***************************************************************
int analyzeHand(int ranksInHand[], int suitsInHand[])
{
int inRow = 0, i, rank, suit, straight = FALSE, flush = FALSE, four = FALSE, three = FALSE, pairs = 0;

    for (suit = 0; suit < 4; suit++)
        if(suitsInHand[suit] == 5)
            flush = TRUE;
            rank = 0;

    while (ranksInHand[rank] == 0)
        rank++;
    for (; rank < 13 && ranksInHand[rank]; rank++)
        inRow++;
    if (inRow == 5)
    {
        straight = TRUE;
    }
    for (rank = 0; rank < 13; rank++)
    {
        if (ranksInHand[rank] == 4)
            four = TRUE;
        if (ranksInHand[rank] == 3)
            three = TRUE;
        if (ranksInHand[rank] == 2)
            pairs++;
    }
    if (straight && flush)
        {
        printf("Straight flush\n\n");
        return (50);
        }
    else if (four)
    {
        printf("Four of a kind\n\n");
        return (25);
    }
    else if (three && pairs == 1)
    {
        printf("Full house\n\n");
        return (10);
    }
    else if (flush)
    {
        printf("Flush\n\n");
        return (8);
    }
    else if (straight)
    {
        printf("Straight\n\n");
        return (5);
    }
    else if (three)
    {
        printf("Three of a kind\n\n");
        return (4);
    }
    else if (pairs == 2)
    {
        printf("Two pairs\n\n");
        return (2);
    }
    else if (pairs == 1)
    {
        printf("Pair\n\n");
        return (1);
    }
    else
    {
        printf("High Card\n\n");
        return (0);
    }
}
//-***************************
void saveToFile(Results *stats, int n)
{
    if(createFile())
    {
        fwrite(&n, sizeof(int), 1, fptr);
        fwrite(stats, sizeof(Results), n, fptr);
        fclose(fptr);
    }
}
//-*****************************************
void uploadFromFile(Results **stats, int *n)
{
    if(openFile())
    {
        fread(n, sizeof(int), 1, fptr);
        (*stats) = (Results*)malloc(*n*sizeof(Results));
        fread(*stats, sizeof(Results), (*n), fptr);
        fclose(fptr);
    }
}
//-*****************************************
bool createFile()
{
    if((fptr = fopen("gameData.bin", "wb+")) == NULL)
    {
        printf("File can`t be created\n");
        return false;
    }
    else
    {
        return true;
    }
}
//-********************
bool openFile()
{
    if((fptr = fopen("gameData.bin", "rb")) == NULL)
    {
        return false;
    }
    else
    {
        return true;
    }
}
