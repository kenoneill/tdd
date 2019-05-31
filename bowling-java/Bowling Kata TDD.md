# Bowling Kata TDD

This is a module contains the starting point for the bowling game kata for Test Driven Development

All that is required is to be able to correctly calculate the score for a game of bowling.

## Rules of Bowling (abridged)

There are 10 frames in a game.

Each frame consists of a maximum of 2 balls.

The score for a frame is calculated as the number of pins knocked in that frame plus any bonus (for Spare or Strike)

Example of a scorecard with no bonus

| Frame  | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    | 9    | 10   |
| ------ | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| Ball 1 | 4    | 1    | 4    | 6    | 1    | 2    | 5    | 1    | 4    | 1    |
| Ball 2 | 4    | 5    | 5    | 2    | 1    | 7    | 3    | 5    | 4    | 5    |
| Score  | 8    | 6    | 9    | 8    | 2    | 9    | 8    | 6    | 8    | 6    |
| Total  | 8    | 14   | 23   | 31   | 33   | 42   | 50   | 56   | 64   | 70   |

The maximum number of pins that can be knocked per frame is 10.



### Spares and Strikes

If a player scores a Spare (ie knocks all 10 pins with 2 balls) then their score is 10 (for the pins knocked) plus the number of pins knocked by the next ball

If a player scores a Strike (ie knocks all 10 pins with the first ball in a frame) then their score is 10 (for the pins knocked) plus the number of pins knocked by the next **two** balls

If a player gets a Strike in the 10th Frame, they get to roll 2 more balls

If a player gets a Spare in the 10th Frame they get to roll 1 more ball

Here is a score card with bonus scores

| Frame  | 1         | 2    | 3    | 4    | 5           | 6    | 7    | 8    | 9    | 10   |      |      |
| ------ | --------- | ---- | ---- | ---- | ----------- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| Ball 1 | 10        | 5    | 5    | 3    | 10          | 10   | 5    | 3    | 3    | 10   | 5    | 6    |
| Ball 2 |           | 2    | 5    | 4    |             |      | 1    | 1    | 3    |      |      |      |
| Bonus  | 7 (5 + 2) |      | 3    |      | 15 (10 + 5) | 8    |      |      |      | 11   |      |      |
| Score  | 17        | 7    | 13   | 7    | 25          | 18   | 6    | 4    | 6    | 21   |      |      |
| Total  | 17        | 24   | 37   | 44   | 69          | 87   | 93   | 97   | 103  | 124  |      |      |



### Perfect Game

A perfect game is defined as 12 strikes in a row, 10 strikes for the normal game, plus 2 more balls for the bonus score in the final frame

| Frame  | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    | 9    | 10   |      |      |
| ------ | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| Ball 1 | 10   | 10   | 10   | 10   | 10   | 10   | 10   | 10   | 10   | 10   | 10   | 10   |
| Ball 2 |      |      |      |      |      |      |      |      |      |      |      |      |
| Bonus  | 20   | 20   | 20   | 20   | 20   | 20   | 20   | 20   | 20   | 20   |      |      |
| Score  | 30   | 30   | 30   | 30   | 30   | 30   | 30   | 30   | 30   | 30   |      |      |
| Total  | 30   | 60   | 90   | 120  | 150  | 180  | 210  | 240  | 270  | 300  |      |      |

