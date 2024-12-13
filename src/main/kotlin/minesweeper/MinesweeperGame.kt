package minesweeper

import minesweeper.cell.CellRange
import minesweeper.view.InputView
import minesweeper.view.OutputView

fun main() {
    val height = InputView.getHeight()
    val width = InputView.getWidth()
    val mineCount = InputView.getMineCount()

    val range = CellRange.of(width, height)

    val minesweeper = Minesweeper.setUp(range)
    val cells = minesweeper.cells

    val mineCells = minesweeper.chooseMineCells(mineCount)
    val cellsWithMines = cells.placeMines(mineCells)

    OutputView.printStartMessage()
    OutputView.printStats(cellsWithMines, width)
}
