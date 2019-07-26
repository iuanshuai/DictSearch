package me.syus.dictsearch.api;

import me.syus.dictsearch.service.DictSearch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RequestMapping(value = {"api/play"})
@org.springframework.stereotype.Controller
@ResponseBody
public class Controller {
    private TreeNode root;

    @RequestMapping(value = "/matrix", method = RequestMethod.POST)
    public List<String> dictSearch(@RequestParam("target") String target, @RequestParam("matrix") String matrixString, @RequestParam("length") int length, @RequestParam("width") int width) {

        String[] targetList = target.split(",");
        for (String word : targetList) {
            System.out.println(word);
        }
        int m = length, n = width;
        char[][] matrix = new char[m][n];
        System.out.println("length = " + length);
        System.out.println("width = " + width);


        int curr = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                matrix[i][j] = matrixString.charAt(curr);
                curr++;
            }
        }

        printMatrix(matrix);

        DictSearch d = new DictSearch(targetList, matrix);
        List<String> ans = d.solution();
        Set<String> set = new HashSet<>();
        for (String str : ans) {
            set.add(str);
        }

        List<String> finalAns = new ArrayList<>();
        for (String str : set) {
            finalAns.add(str);
        }


        return finalAns;

    }

    private void printMatrix(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

}
