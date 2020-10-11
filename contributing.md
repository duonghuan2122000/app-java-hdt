**Hướng dẫn contribute cho ứng dụng.**

## Cài đặt
Đầu tiên fork repository về github của bản thân và lấy url của repo đó

    git clone url-git-repo
    cd app-java-hdt
url-git-repo là url của repo cần contribute sau khi fork về tài khoản github của bản thân.
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
