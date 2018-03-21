/**
 *
 * <p>
 * Title: ddd.java
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2017
 * </p>
 *
 * <p>
 * Company: zyx@taeyeon.cn
 * </p>
 *
 * @author KEN
 *
 * @date 2018年3月8日
 *
 * @version 1.0
 *
 */

package com.zyx.nioTest;

/**
 * @author KEN
 *
 */

import java.io.IOException;
import java.nio.channels.SelectionKey;

public interface ITCPProtocol {
    void handleAccept(SelectionKey key) throws IOException;

    void handleRead(SelectionKey key) throws IOException;

    void handleWrite(SelectionKey key) throws IOException;
}
