package minesweeper

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import minesweeper.cell.CellRange

class MinesweeperTest : StringSpec({

    "지뢰찾기는 높이와 너비로 셀이 생성된다." {
        // Arrange:
        val width = 3
        val height = 3
        val range = CellRange.of(width, height)

        // Act:
        val cell = Minesweeper.setUp(range)

        // Assert:
        cell.cells.cells.size shouldBe 9
    }

    "생성된 셀 내에서 지뢰의 위치를 생성한다." {
        // Arrange:
        val range = CellRange.of(3, 3)
        val minesweeper = Minesweeper.setUp(range)
        val cells = minesweeper.cells

        // Act:
        val mineCells = minesweeper.chooseMineCells(1)

        // Assert:
        mineCells.size shouldBe 1
        mineCells.all { mineCell -> cells.cells.contains(mineCell) } shouldBe true
    }
})
