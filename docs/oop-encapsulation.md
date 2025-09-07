# static の本質とは？

## 結論
- `static` = **クラス全体で共有する変数/メソッド**
- 「固定」ではなく「共有」と「長寿命」

## なぜ必要か
- バッテリーの「総製造数」のように、全インスタンスで共通の情報を管理したい場合
- 各オブジェクトごとに個別に持つと意味が壊れる

## よくある誤解
- 「static = 変更できない」 → ✖ それは `final` の役割
- 正しくは「クラスに属する」こと

##　非 static フィールド
→ 各インスタンスごとに メモリ上に別々の場所が確保される。
だから Battery b1, Battery b2 があれば、それぞれが「自分専用の manufacturedCount」を持つ。
→ 結果として、カウントがインスタンスごとにリセットされる。
##　static フィールド
→ クラスに対して 1箇所だけメモリが割り当てられる。
どのインスタンスからアクセスしても同じ場所を見ている。
→ 全部のオブジェクトで共有されるから「累計カウンタ」にできる。

## コード例
```java
class Battery {
    private static int manufacturedCount = 0;
    public Battery() {
        manufacturedCount++;
    }
    public static int getManufacturedCount() {
        return manufacturedCount;
    }
}