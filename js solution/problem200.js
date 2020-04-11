/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    var result = 0
    for(var i = 0;i < grid.length;i++) {
        for(var j = 0;j < grid[i].length;j++) {
            if(grid[i][j] == '1') {
                result++
                dfs(grid,i,j)
            }
        }
    }
    return result
}

function dfs(grid,i,j) {
    if(i < 0 || j < 0 || i == grid.length || j == grid[i].length || grid[i][j] == '0')
        return
    //把岛炸沉
    grid[i][j] = '0'
    var ci = [1,-1,0,0]
    var cj = [0,0,1,-1]
    for(var k = 0;k < ci.length;k++) {
        dfs(grid,i + ci[k],j + cj[k])
    }
}

//test
var a = [[1,1,0,0,0],[1,1,0,0,0],[0,0,1,0,0],[0,0,0,1,1]]
var b = [[1,1,1,1,0],[1,1,0,1,0],[1,1,0,0,0],[0,0,0,0,0]]
console.log(numIslands(a))
console.log(numIslands(b))
