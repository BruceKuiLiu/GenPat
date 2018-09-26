/**
 * Copyright (C) SEI, PKU, PRC. - All Rights Reserved.
 * Unauthorized copying of this file via any medium is
 * strictly prohibited Proprietary and Confidential.
 * Written by Jiajun Jiang<jiajun.jiang@pku.edu.cn>.
 */

package mfix.core.parse.diff;

import mfix.common.util.Constant;
import mfix.core.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * @author: Jiajun
 * @date: 2018/9/25
 */
public class DiffTest extends TestCase {

    @Test
    public void test_extractFileDiff() {
        String srcFile = testbase + Constant.SEP + "src_Project.java";
        String tarFile = testbase + Constant.SEP + "tar_Project.java";
        List<Diff> diffs = Diff.extractFileDiff(srcFile, tarFile, AstDiff.class);
        for(Diff diff : diffs) {
            System.out.println("------------------");
            System.out.println(diff.miniDiff());
            System.out.println("------------------\n");
        }
    }

    @Test
    public void test_extractFileDiff2() {
        String srcFile = testbase + Constant.SEP + "src_Project.java";
        String tarFile = testbase + Constant.SEP + "tar_Project.java";
        List<Diff> diffs = Diff.extractFileDiff(srcFile, tarFile, TextDiff.class);
        for(Diff diff : diffs) {
            System.out.println("------------------");
            System.out.println(diff.miniDiff());
            System.out.println("------------------\n");
        }
    }
}
