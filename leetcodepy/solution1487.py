class Solution1487:
    def getFolderNames(self, names: list[str]) -> list[str]:
        dic = dict()
        res = []
        for name in names: 
            getIndex(name)
            if name in dic:
                t = dic[name]
                if len(t) > 0:
                    tNum = t[len(t) - 1] + 1
                    t.append(tNum)
                    name = name + "(" + str(tNum) + ")"
            else:
                t = []
                t.append(0)
                dic[name] = t
            res.append(name)
        return res

    def getIndex(name: str) -> int:
        for i in len(name) - 1:
            if name[i] == '(':
                return i
        return 0