/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package com.nhnacademy;

import com.nhnacademy.livelock.Counter;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task = () -> {
            while (counter.getCount() < 10) {
                counter.increment();
            }
        };

        // 라이브락은 잠금을 하는 타이밍과 잠금 해제의 타이밍의 차이로 나오는 문제라 생각해도 된다
        Thread threadA = new Thread(task, "counter-A");
        Thread threadB = new Thread(task, "counter-B");

        threadA.start();
        threadB.start();
    }


}
