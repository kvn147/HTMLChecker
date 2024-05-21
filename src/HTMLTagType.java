/**
 * This enumerated type is used in HTMLParser and HTMLTag to mark the HTMLTag type. There
 * are three tag types defined
 * For example: <p> is an opening tag
 *              </p> is a closing tag
 *              <br /> is a self-closing tag
 */
public enum HTMLTagType {
    SELF_CLOSING,
    OPENING,
    CLOSING
}
