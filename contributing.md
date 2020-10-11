**Hướng dẫn contribute cho ứng dụng.**
## Cài đặt

    git clone https://github.com/duonghuan2122000/app-java-hdt.git
    cd app-java-hdt
## Tạo branch

    git branch ten-branch
    git checkout ten-branch
Ví dụ:

    git branch hoang
    # or 
    git branch khoat

## Commit
    git add .
    git commit -m "tên commit"
    git push origin ten-branch

Lưu ý: Trước khi push nhớ kiểm tra commit hiện tại là mới nhất (tức là đang ở commit cuối cùng của project nếu không sẽ bị lỗi)

    git pull
