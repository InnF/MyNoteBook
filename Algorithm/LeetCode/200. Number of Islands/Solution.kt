/**
 * Created by Inno Fang on 2018/1/12.
 */


/**
 * 47 / 47 test cases passed.
 * Status: Accepted
 * Runtime: 448 ms
 */
class Solution {

    private val direct = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
    private var rows = 0
    private var cols = 0
    private var visited = Array(rows, { BooleanArray(cols) })

    fun numIslands(grid: Array<CharArray>): Int {
        rows = grid.size
        if (rows == 0) return 0
        cols = grid[0].size
        visited = Array(rows, { BooleanArray(cols) })

        var res = 0

        (0 until rows).forEach { i ->
            (0 until cols).forEach { j ->
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++
                    dfs(grid, i, j)
                }
            }
        }
        return res
    }

    private fun dfs(grid: Array<CharArray>, x: Int, y: Int) {
        visited[x][y] = true

        (0 until 4).forEach { i ->
            val newX = x + direct[i][0]
            val newY = y + direct[i][1]
            if (inArea(newX, newY) && grid[newX][newY] == '1' && !visited[newX][newY]) {
                dfs(grid, newX, newY)
            }
        }
    }

    private fun inArea(x: Int, y: Int): Boolean {
        return x in (0 until rows) && y in (0 until cols)
    }
}

fun main(args: Array<String>) {
    Solution().numIslands(arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0'))
    ).let(::println)

    Solution().numIslands(arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1'))
    ).let(::println)

}

// 130 Surrounded Regions
// 417 Pacific Atlantic Water Flow